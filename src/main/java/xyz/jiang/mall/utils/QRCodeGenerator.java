package xyz.jiang.mall.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import xyz.jiang.mall.common.Constant;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @Program: mall
 * @Classname QRCodeGenerator
 * @Description: 生成二维码的类
 * @Author: JiangKan
 * @Create: 2020-10-15
 **/
public class QRCodeGenerator {
    public static void generateQRCodeImage(String text, int w, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, w, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }

    public static void main(String[] args) throws IOException, WriterException {
        generateQRCodeImage("hello world",350,350, "z:/xx.png");
    }
}
