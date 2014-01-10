package com.pojo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.UUID;

public class RandomValidateCode {

	 public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//�ŵ�session�е�key
	    private Random random = new Random();
	    private String randString = "123456789";//����������ַ���
	    
	    private int width = 80;//ͼƬ��
	    private int height = 26;//ͼƬ��
	    private int lineSize = 40;//����������
	    private int result=0;//��Ž��
	    
	    /*
	     * �����������
	     */
	    private Font getFont(){
	        return new Font("Fixedsys",Font.CENTER_BASELINE,18);
	    }
	    /*
	     * ��ø�������ɫ
	     */
	    private Color getRandColor(int fc,int bc){
	        if(fc > 255)
	            fc = 255;
	        if(bc > 255)
	            bc = 255;
	        int r = fc + random.nextInt(bc-fc-16);
	        int g = fc + random.nextInt(bc-fc-14);
	        int b = fc + random.nextInt(bc-fc-18);
	        return new Color(r,g,b);
	    }
	    /**
	     * �������ͼƬ
	     */
	    public void getRandcode(Map<String,Object> session) {
	        
	        //BufferedImage���Ǿ��л�������Image��,Image������������ͼ����Ϣ����
	        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
	        Graphics g = image.getGraphics();//����Image�����Graphics����,�Ķ��������ͼ���Ͻ��и��ֻ��Ʋ���
	        g.fillRect(0, 0, width, height);
	        g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
	        g.setColor(getRandColor(110, 133));
	        
	        //���Ƹ�����
	        for(int i=0;i<=lineSize;i++){
	            drowLine(g);
	        }
	        
	        //�洢�������
	        String randomString = "";
	       /* for(int i=1;i<=stringNum;i++){
	            randomString=drowString(g,randomString,i);
	        }*/
	        
	        //���Ƶ�һ������
	        randomString=drowString(g,0);
	        result+=Integer.parseInt(randomString);
	        //���� +
	        g.translate(random.nextInt(3), random.nextInt(3));
	        g.drawString("+", 20, 18);
	        //���Ƶڶ�������
	        randomString=drowString(g,3);
	        result+=Integer.parseInt(randomString);
	       //���� =
	        g.translate(random.nextInt(3), random.nextInt(3));
	        g.drawString("=", 60, 18);
	        
	        session.remove(RANDOMCODEKEY);
	        session.put(RANDOMCODEKEY, result);
	        g.dispose();//�ͷ�graphic��Դ

	        File file=new File("c:/image/a.jpeg");
	        
	        try {
	           ImageIO.write(image, "JPEG", file);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /*
	     * ��������
	     */
	    private String drowString(Graphics g,int i){
	        g.setFont(getFont());
	        g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
	        String rand = getRandomString(random.nextInt(randString.length()))+getRandomString(random.nextInt(randString.length()));
	        g.translate(random.nextInt(3), random.nextInt(3));//��ͼ�������ĵ�ԭ��ƽ�Ƶ���ǰ����ϵ�еĵ� (x, y)
	        g.drawString(rand, 13*i, 18);
	        return rand;
	    }
	    /*
	     * ���Ƹ�����
	     */
	    private void drowLine(Graphics g){
	        int x = random.nextInt(width);
	        int y = random.nextInt(height);
	        int xl = random.nextInt(13);
	        int yl = random.nextInt(15);
	        g.drawLine(x, y, x+xl, y+yl);
	    }
	    /*
	     * ��ȡ������ַ�
	     */
	    public String getRandomString(int num){
	        //return String.valueOf(randString.charAt(num));
	    	return randString.charAt(num)+"";
	    }
	
}
