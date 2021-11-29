const express = require('express')
/*
const {
    start,
    jump, 
} = require('./gameFolder/game');
*/
const app = express()

app.get('', (req, res) => {
    res.sendFile(__dirname + '/index.html')
})
app.use('/gameResources', express.static(__dirname+"/gameResources"));
app.use('/gameFolder', express.static(__dirname+"/gameFolder"));

app.listen(3000, () => {
    console.log('Server Start')
})

// 아두이노 연동
var SerialPort = require('serialport');

const parsers = SerialPort.parsers;
const parser = new parsers.Readline(
        {
            delimiters: '\r\n'
        }
);

var port = new SerialPort('COM10',{
    baudRate: 9600,
    dataBits: 8,
    parity: 'none',
    stopBits: 1,
    flowControl: false
});

port.pipe(parser);

const jQuery = require('jquery');
const window = require('window');

const keyEvent = function() {
    const event = jQuery.Event( "keypress", { keyCode: 38 } );
    $(window).trigger(event);
}
// var event = window.createEvent("Events");
// event.initEvent('keydown', true, true);
// event.keyCode = 38;


parser.on('data', function(data){
    console.log(data);
    const promise = new Promise((resolve, reject)=>{
        if(data.startsWith('J')){
            resolve('Jump');
        }
        else{
            reject('아직 구현 안함');
        }
    });

    promise
        .then((message) => {
            console.log(data);
            // window.dispatchEvent(event);
            keyEvent();
        })
        .catch((error) => {
            //console.error(`${data}: 자리 이용중`);
        })
        .finally(() => {
            //console.log('promise 작동중');
        })
});

