//#1 npm install
//#2 node index.js

const express = require('express')
const nodemailer = require('nodemailer')
const app = express()
const port = 3000

app.use(express.json());

const transporter = nodemailer.createTransport({
    service : "gmail",
    secure : "false",
    auth: {
        user: "equipefoodexpress@gmail.com",
        pass: "qpazewvjnopmdzcu"
    },
    tls: {
        rejectUnauthorized: false
    }
})

app.post('/enviaremail', (req, res) =>{
    const { email, subject, html } = req.body;

    console.log(html);

    const mailSent = transporter.sendMail({
        from: "equipefoodexpress@gmail.com",
        to: email,
        subject: subject,
        html: html
    }).then(() => {
        res.status(200).send(req.body);
        console.log('enviado');
    }).catch((err) => {
        console.log(err);
        res.send(err);
    });
})

app.listen(port, () =>{
    console.log(`Servidor de email on: ${port}`)
})