// Import the functions you need from the SDKs
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
import app from "./conexao.js";

import { getStorage, ref, uploadBytes, getDownloadURL } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-storage.js";


// Function to upload a file to Firebase Storage
function uploadFile(file) {
  const storage = getStorage(app);
  const storageRef = ref(storage, 'images/' + file.name);

  uploadBytes(storageRef, file).then(snapshot => {
    console.log('Uploaded a file:', snapshot.metadata.name);

    // Get the download URL of the uploaded file
    getDownloadURL(storageRef).then(downloadURL => {
      console.log('File available at', downloadURL);
    }).catch(error => {
      console.error('Error getting download URL:', error);
    });
  }).catch(error => {
    console.error('Error uploading file:', error);
  });
}

document.addEventListener("DOMContentLoaded", function () {
  const fileInput = document.getElementById('file-input');
  const uploadButton = document.getElementById('uploadButton');

  uploadButton.addEventListener('click', () => {
    const file = fileInput.files[0];
    if (file) {
      uploadFile(file);
    }
  });
});