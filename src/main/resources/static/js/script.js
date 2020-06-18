var stompClient = null;

window.onload = connect();

function connect() {
    var socket = new SockJS('/hello');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function(message){
            showGreeting(JSON.parse(message.body));
        });
    });
}

function sendName(id) {
    var name = id;
    stompClient.send("/app/hello", {}, JSON.stringify({ 'id': name }));
}

function showGreeting(message) {


    console.log(message);
    if (message.length > 0) {
        for (var i = 0; i < message.length; i++) {
            var quantityInCart = "quantityInCart" + message[i].id;
            document.getElementById(quantityInCart).innerHTML = message[i].quantity;
            document.getElementById("resultInput").value = "Стоимость товаров в корзине :" + message[i].totalCost ;
        }
    } else {
        document.getElementById("resultInput").value = "error";
    }

}