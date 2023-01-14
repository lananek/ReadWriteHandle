package test;

import com.company.*;

import com.company.ReadWrite;
import org.junit.Assert;
import org.junit.Test;

public class DecoratorTest {
    @Test
    public void zipUnzip(){
        String path = "testFiles/test1.txt";
        ReadWrite readWrite = new ReadWrite();
        ZipperFiles zipperFiles = new ZipperFiles(readWrite);
        String text1 = readWrite.read(path);
        zipperFiles.write("test1.zip", text1);
        String text2 = zipperFiles.read("test1.zip");

        Assert.assertEquals(text1, text2);

    }

    @Test
    public void encodeDecode(){
        String path = "testFiles/test1.txt";
        ReadWrite readWrite = new ReadWrite();
        EncryptionFiles encryptionFiles = new EncryptionFiles(readWrite);
        String text1 = readWrite.read(path);
        encryptionFiles.write("test1.zip", text1);
        String text2 = encryptionFiles.read("test1.zip");

        Assert.assertEquals(text1, text2);

    }

    @Test
    public void compressDecompress(){
        String path = "testFiles/test1.txt";
        ReadWrite readWrite = new ReadWrite();
        compressFiles compressFiles = new compressFiles(readWrite);
        String text1 = readWrite.read(path);
        compressFiles.write("test1.zip", text1);
        String text2 = compressFiles.read("test1.zip");

        Assert.assertEquals(text1, text2);

    }
}
