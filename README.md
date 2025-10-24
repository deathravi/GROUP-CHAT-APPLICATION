# GROUP-CHAT-APPLICATION
💬 Java Chat Application A real-time GUI-based chat application built with Java Swing, featuring client-server architecture with SQLite database integration for message persistence.
💬 Java Chat Application
A real-time GUI-based chat application built with Java Swing, featuring client-server architecture with SQLite database integration for message persistence.

✨ Features
Real-time Messaging: Instant message exchange between client and server

Beautiful GUI: Modern chat interface with emoji support

Message Persistence: All messages stored in SQLite database

Database Viewer: Built-in GUI to view chat history

Cross-platform: Runs on Windows, macOS, and Linux

Simple Setup: Easy to compile and run

🛠️ Tech Stack
Java Swing - GUI Framework

Java Socket Programming - Network communication

SQLite - Database for message storage

JDBC - Database connectivity

📸 Application Preview
Chat Interfaces
Server Side: "Monkey D Luffy" chat interface

Client Side: "Fire Fist" chat interface

Real-time Messaging: Instant message delivery between clients

Message History: Persistent storage of all conversations

Database Management
GUI Database Viewer: Browse all messages in a table format

Message Logging: Automatic saving of sent and received messages

Time Stamping: Each message includes timestamp

🚀 Quick Start
Prerequisites
Java JDK 8 or higher

VS Code with Java Extension Pack (recommended)

Installation
Clone the repository

bash
git clone https://github.com/yourusername/java-chat-app.git
cd java-chat-app
Download SQLite JDBC Driver

The application will automatically download the required JDBC driver

Or manually download from: https://github.com/xerial/sqlite-jdbc

Run the Application

First, start the Server:

bash
javac Server.java
java Server
Then, start the Client:

bash
javac Client.java
java Client
View Database (Optional):

bash
javac DatabaseViewer.java
java DatabaseViewer
📁 Project Structure
text
java-chat-app/
├── Client.java              # Client-side chat interface
├── Server.java              # Server-side chat interface  
├── SimpleDB.java            # Database management utilities
├── DatabaseViewer.java      # GUI for viewing chat history
├── lib/                     # Dependencies (auto-created)
│   └── sqlite-jdbc.jar      # SQLite JDBC driver
└── chat.db                  # Database file (auto-created)
🎯 How to Use
Start Server: Run Server.java - this opens the server chat window

Start Client: Run Client.java - this opens the client chat window

Chat: Type messages in either window and press Send

View History: Run DatabaseViewer.java to see all messages

🔧 Configuration
Port: Default port 6001 (configurable in code)

Database: SQLite database file chat.db

UI: Customizable colors and themes in source code

🌟 Key Components
Client-Server Architecture
Server: Listens on port 6001, handles multiple clients

Client: Connects to server, sends/receives messages

Real-time Sync: Instant message updates between connected clients

Database Schema
sql
CREATE TABLE messages (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    sender TEXT,
    message TEXT, 
    time TEXT
);
GUI Features
Modern chat bubbles with timestamps

Emoji support for user profiles and icons

Responsive design with scrollable message history

Database viewer with refresh functionality

🐛 Troubleshooting
Common Issues:

"Connection refused" - Ensure server is running before client

"Class not found" - Check SQLite JDBC driver is in lib folder

"Port already in use" - Change port number or close existing instance

🤝 Contributing
Contributions welcome! Feel free to:

Report bugs

Suggest new features

Submit pull requests

Improve documentation

📄 License
This project is open source and available under the MIT License.

⭐ Star this repo if you find it helpful!

Alternative shorter version for GitHub repo description:
Real-time Java Chat App with GUI & Database - A feature-rich chat application built with Java Swing, Socket programming, and SQLite. Includes real-time messaging, persistent storage, and a database viewer GUI. Perfect for learning client-server architecture and Java GUI development.
