var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#status_message');

var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
}

connect();

function onConnected() {
    stompClient.subscribe('/topic/publicChatRoom', onMessageReceived);
}


function onError(error) {
    // alert('An error has occurred when send this message~ ');
}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if (messageContent && stompClient) {
        var chatMessage = {
            sender: $('#sId').val(),
            content: messageInput.value,
            time: new Date()
        };
        stompClient.send("/app/sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';

    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var action = '';
    if (message.sender == $('#sId').val()) {
        action = "  <div class='outgoing_msg'>" +
            "                                    <div class='sent_msg'>" +
            "                                                <p>" + message.content + "</p>" +
            "                                        <span class='time_date'>" +formatAMPM(message.time) + "</span></div>" +
            "                                </div>";
    }
    else {
        action = "<div class='incoming_msg'>" +
            "                                        <div class='received_msg'>" +
            "                                            <div class='received_withd_msg'>" +
            "                                                <p>" + message.content + "</p>" +
            "                                                <span class='time_date'>" +formatAMPM(message.time) + "</span></div>" +
            "                                        </div>" +
            "                                    </div>";
    }


    $('.msg_history').append(action);

}

messageForm.addEventListener('submit', sendMessage, true);

function formatAMPM(date) {
    var time = new Date(date);
    var hours = time.getHours();
    var minutes = time.getMinutes();
    var ampm = hours >= 12 ? 'PM' : 'AM';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + ' ' + ampm;
    return strTime;
}