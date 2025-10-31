# Chat-application-using-java
💬 Ghop — Go Hangout On Platform

A Java-based real-time chat application built using Socket Programming and Java Swing.
This project demonstrates client-server communication, multi-threading, and GUI-based interaction, allowing multiple users to chat seamlessly over a local network.

🚀 Features

✅ Real-time chat between server and multiple clients
✅ Simple and elegant Swing-based GUI
✅ Uses Socket Programming for network communication
✅ Multi-threaded server to handle multiple clients simultaneously
✅ User-friendly message interface
✅ Lightweight and fast — built purely in core Java

🧠 Concept Behind “Ghop”

Ghop stands for Go Hangout On Platform — a chat environment designed to let users hang out, talk, and connect digitally.
It represents an easy-to-use platform for peer-to-peer or group text communication built with simplicity and reliability in mind.

🗂️ Folder Structure
Ghop/
│
├── README.md
├── Server.java
├── Client.java
└── ChatGUI.java

⚙️ How It Works

Server runs and listens for incoming connections.

Clients connect to the server using a socket (IP address and port number).

Each client runs on a separate thread, enabling simultaneous messaging.

Messages from one client are broadcasted to others through the server.

🧰 Technologies Used
Component	Technology
Language	Java (JDK 17 or higher)
GUI	Java Swing
Networking	Java Sockets (TCP)
Threading	Multi-threaded Server & Client Handling
