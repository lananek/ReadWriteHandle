package com.company;

import java.util.Base64;

public class EncryptionDecorator extends DataDecorator {
    public EncryptionDecorator(IData data) {
        super(data);
    }

    @Override
    public String read(String filename) {
        return decode(super.read(filename));
    }
    @Override
    public void write(String filename, String text) {
        super.write(filename, encode(text));
    }

  
   void encrypt(String content, String fileName) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
        byte[] iv = cipher.getIV();

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher)) {
            try {
                fileOut.write(iv);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                cipherOut.write(content.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    String decrypt(String fileName) {
        String content;

        try (FileInputStream fileIn = new FileInputStream(fileName)) {
            byte[] fileIv = new byte[16];
            fileIn.read(fileIv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(fileIv));

            try (
                    CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher);
                    InputStreamReader inputReader = new InputStreamReader(cipherIn);
                    BufferedReader reader = new BufferedReader(inputReader)
            ) {

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                content = sb.toString();
            } 

        return content;
    }
}
