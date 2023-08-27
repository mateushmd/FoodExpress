package com.foodexpress.model.imgFirebase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

abstract public class FirebaseStorage {
    // Caminho para o arquivo de credenciais do Firebase Admin SDK
    // Este é um caminho para o download do json feito nas configurações do projeto
 static final String JSON_CONFIG = "{\n" +
            "  \"type\": \"service_account\",\n" +
            "  \"project_id\": \"restricted-d6b24\",\n" +
            "  \"private_key_id\": \"86b7489c7aa89bb37fccc2bd423df36d6c8a4b99\",\n" +
            "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCuP4wAf23GhkBz\\ndhI2WsaWF7GxAgaDaspsgeAkPAvRq1TmEpYg7NFXpDD2NB+aj0XJ5MGPBJcYXtO0\\nnAwBX58Na5g/VRCY46iqi0XlSKCJsZj+iwM3zT0KHlblaL4cj5KsABKfVvbIPLSV\\nk46sZKqRtPcjXkD1inUIpkNRRecSnJN8eRLvgRMIhnA5w8ij/99ZjiJxAicLUGm2\\nuzbWEzRSyr9BozS+71YriGAfohSy8C1RbPIXUkG1NThRwi67NL3MBL3pswNYxSPt\\nQpyifFxtLGP7jmyeh2Rz65sS8Et9VOARbML8K1FakIbCpTBSW0+NbHdcOEbq7N2k\\nUBQp4CqRAgMBAAECggEAF8FonhnBVs8vQr5+WaQzDjvhOQtYZXq96aCkNPRtvRJB\\nYxN2HbuDh9IF7c7p3xm4zz9NZyjeS4+EB8u9dEN7zOnWCg5YEqv47vVJXGq0HkmU\\n3OEJWYZ006gSuzh2MLEfMy1YXJpPzzk9emXxTc30liRIjC0ZqJANiBYYt+ASkm4F\\nlaYizLI3sxBFwiPDkLbyj7Lpl4exR394rUdb458zKeWAZHSlnddAOAFRpFRQHoJP\\n5hn6Tf6mZKqNC74/1YrHJiWhuoOFxzm1wtvvSY/se6Lx9gQcQW8FgzyM1sdoSxt3\\nAlMHEByLa33ZAnjzBybc61MjxmtiBMt20CVlwzOPVQKBgQD0fE8KnwGr2KNpESym\\nBcZRbIgcBtgSKrWGnrDr5cxKeGeClFSEAQodnWWHcT2IJtEWdA20y13BzKCUUjN0\\n5BpGm9PsHZT20x/oTA2pfhLp0fccozaspHpIQC5czKiETwMzvmSC9pxb1or8+n7G\\nAkbdX5Xf0mVa7oGDgNSpV4VFVQKBgQC2dGgqi1WcFdJB2Q73kZw+/fqteQxWwfCl\\nK111QFB193NWoxd9az6tr2Se1AdYT/faUWjiMqnmVpBHh38YDfgVrDfJGrl+L25v\\nn8/EgPWkNz4kzID4/HUMJkVabiDlHWgnk+R8/VM0O/mpbu2pmGwtSzn9mlZdjQyA\\nzwfsSKEQTQKBgBDNWkFInDzLLq/R1leyneaKpvAGKGNXPBJ8ZXxQ1rFnhPWcbBKG\\nX8OZRZkBV1E8GbKJV0fNkiv3fDG1VIP8CTJBE1du0QYFjHPShj3XxET9gRYewWss\\nAptkjcsi5ZHyPC4aL54whJ5rKDIqpPvGvEgKgapYM08EhTIccIES2r3hAoGBAJhC\\nbodKfafi4fLHk+Dv58b9pktL4Asqj4sWtEhb4ol/dgYP1lN4wvaojryoznRZT8ol\\n8/QIOZaaGI9IuLw3NBfJ/0fZAIEYTf3jDLy8rcFbxIVrEBo4e+kmquu7ScJJlxio\\nJ55SvTOy9Tb69mR4aZYm1/8V5Arv4UZA/yikt5xlAoGAOaz9HI2PcUVObC1NClqV\\nFk9wx9yg7BkUL0uJI2sBxU3jx2jOwDyl+67GYyeSSaFekkTC2ry1efTLfW8uki1p\\nYhv6snCwQU4A3gGkoPOoGctLsJSMhddCasVRgEHr9tRwGd1Msd3bRSvZTtMrWJqj\\nd2v7bF9pSeuYdf4x3Ju/D+o=\\n-----END PRIVATE KEY-----\\n\",\n" +
            "  \"client_email\": \"firebase-adminsdk-bw6ft@restricted-d6b24.iam.gserviceaccount.com\",\n" +
            "  \"client_id\": \"101341715885785351619\",\n" +
            "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
            "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
            "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
            "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-bw6ft%40restricted-d6b24.iam.gserviceaccount.com\",\n" +
            "  \"universe_domain\": \"googleapis.com\"\n" +
            "}";
 // Nome do bucket do Firebase Storage (sem o esquema "gs://")
    String bucketName = "restricted-d6b24.appspot.com";

    // Configurando as credenciais do Firebase Admin SDK
    GoogleCredentials credentials;
    StorageOptions options;
    Storage storage;
    Bucket bucket;

    public FirebaseStorage() {
        try {
            credentials = GoogleCredentials.fromStream(new ByteArrayInputStream(JSON_CONFIG.getBytes(StandardCharsets.UTF_8)));
            options = StorageOptions.newBuilder().setCredentials(credentials).build();
            storage = options.getService();

            // Obtendo referência para o bucket do Firebase Storage
            bucket = storage.get(bucketName);
        } catch (IOException e) {
        }
    }
     private int counter = 1;
     
     public static byte[] getImageDataFromUrl(String imageUrl) throws IOException {
        try (InputStream inputStream = new URL(imageUrl).openStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return outputStream.toByteArray();
        }
    }

    public abstract void uploadByLink(String imageUrl) throws IOException;
    public abstract void upload(String imgLocal) throws FileNotFoundException;
    public abstract void delete (String imgLocal) throws FileNotFoundException;
    public abstract void readImageAsUrl(String imgLocal) throws FileNotFoundException;


    protected String generateUniqueFileName() {
        return counter++ + "_" + UUID.randomUUID().toString() + ".png";
    }
}

