package java131718;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

//import java131718.MyButtonUI;

/**
 * @author sherman,toulzx
 * @create 2021-06-15 14:30
 * @description
 */

public class official extends JFrame implements ActionListener {
    static JFrame jFrame;
    static JLabel labelA = new JLabel("A");
    static JLabel labelC = new JLabel("C");
    static JLabel labelO = new JLabel("O");
    static JLabel labelP = new JLabel("P");
    static JLabel labelS = new JLabel("S");
    static JLabel labelZ = new JLabel("Z");
    static JTextField jTextField;
    static JLabel lb_result;

    //static  MyButtonUI btnUI = new MyButtonUI();

    // store operator and operands
    String operand1, operator, operand2, result;

    int binaryBits;

    // default constructor
    official()
    {
        operand1 = operand2 = result = "";
        operator = "";
        binaryBits =8;

        //jFrame.setBackground(Color.blue);
    }


    public static void InitGlobalFont(Font font) {
        FontUIResource fontResource = new FontUIResource(font);
        for(Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof FontUIResource) {
                System.out.println(key);
                UIManager.put(key, fontResource);
            }
        }
    }

    // main function
    public static void main(String[] args)
    {
        // 创建顶层容器
        jFrame = new JFrame("Binary Calculator");

        jFrame.setSize(600, 800);

        //设置于屏幕正中心显示
        jFrame.setLocationRelativeTo(null);

        //禁止修改窗体大小
        jFrame.setResizable(false);

        //使关闭窗口时终止后台程序
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

////@Resource: https://blog.csdn.net/qq_45137584/article/details/111411839
//        try
//        {
//            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//        }
//        catch(Exception e)
//        {
//            System.out.println("加载皮肤失败！");
//        }

        InitGlobalFont(new Font("Dotum", Font.PLAIN, 25));
        // create a object of class
        official object = new official();
//        object.setUI(new MyButtonUI);

        // create a textfield
        jTextField = new JTextField(60);
        jTextField.setEditable(false);
        jTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField.setBorder(new EmptyBorder(0,0,0,0));
        // The font setting corresponding to the initial @binaryBits of 8
        jTextField.setFont(new Font("Times New Roman", Font.ITALIC, 35));

        // create a label to show the result
        lb_result = new JLabel("");
        lb_result.setHorizontalAlignment(SwingConstants.RIGHT);
        //  The font setting corresponding to the initial @binaryBits of 8
        lb_result.setFont(new Font("Consolas", Font.BOLD, 70));

        // create status labels
        labelA.setForeground(Color.gray);
        labelA.setFont(new Font("Consolas", Font.PLAIN, 20));
        labelC.setForeground(Color.gray);
        labelC.setFont(new Font("Consolas", Font.PLAIN, 20));
        labelO.setForeground(Color.gray);
        labelO.setFont(new Font("Consolas", Font.PLAIN, 20));
        labelP.setForeground(Color.gray);
        labelP.setFont(new Font("Consolas", Font.PLAIN, 20));
        labelS.setForeground(Color.gray);
        labelS.setFont(new Font("Consolas", Font.PLAIN, 20));
        labelZ.setForeground(Color.gray);
        labelZ.setFont(new Font("Consolas", Font.PLAIN, 20));


        // create number buttons and some operators
        JButton btn_0 = new JButton("0");
        JButton btn_1 = new JButton("1");

        JButton btn_clear = new JButton("CLR");
        JButton btn_equal = new JButton("=");

        JButton btn_plus = new JButton("+");
        JButton btn_minus = new JButton("-");

        JButton btn_and = new JButton("AND");
        JButton btn_or = new JButton("OR");
        JButton btn_xor = new JButton("XOR");
        JButton btn_not = new JButton("NOT");
        JButton btn_comp = new JButton("COMP");

        JRadioButton rbtn_8 = new JRadioButton("8");
        JRadioButton rbtn_16 = new JRadioButton("16");
        JRadioButton rbtn_32 = new JRadioButton("32");

        // Create a button group and add two radio buttons to the group
        ButtonGroup rbtnGroup = new ButtonGroup();
        rbtnGroup.add(rbtn_8);
        rbtnGroup.add(rbtn_16);
        rbtnGroup.add(rbtn_32);
        // Set the first radio button to be selected
        rbtn_8.setSelected(true);


        // add action listeners
        btn_0.addActionListener(object);
        btn_1.addActionListener(object);

        btn_clear.addActionListener(object);
        btn_equal.addActionListener(object);

        btn_plus.addActionListener(object);
        btn_minus.addActionListener(object);

        btn_and.addActionListener(object);
        btn_or.addActionListener(object);
        btn_xor.addActionListener(object);
        btn_not.addActionListener(object);
        btn_comp.addActionListener(object);

        rbtn_8.addActionListener(object);
        rbtn_16.addActionListener(object);
        rbtn_32.addActionListener(object);



        // create a panel
        JPanel jPanel = new JPanel(null);

        // set the axis and size
        int x1 = 5;
        int y1 = 10;
        int width1 = 20;
        int height1 = 20;
        labelA.setBounds(x1+0*(width1+3),y1-0,width1-0,height1-0);
        labelC.setBounds(x1+1*(width1+3),y1-0,width1-0,height1-0);
        labelO.setBounds(x1+2*(width1+3),y1-0,width1-0,height1-0);
        labelP.setBounds(x1+3*(width1+3),y1-0,width1-0,height1-0);
        labelS.setBounds(x1+4*(width1+3),y1-0,width1-0,height1-0);
        labelZ.setBounds(x1+5*(width1+3),y1-0,width1-0,height1-0);
        int x2 = 5;
        int y2 = y1 + height1 + 10;
        int width2 = 570;
        int height2 = 50;
        jTextField.setBounds(x2,y2,width2,height2);
        int x3 = 0;
        int y3 = y2 + height2 + 10;
        int width3 = 580;
        int height3 = 100;
        lb_result.setBounds(x3, y3, width3, height3);
        int x4 = 5;
        int y4 = y3 + height3 + 10;
        int width4 = 187;
        int height4 = (int)187/2;
        btn_not.setBounds(x4, y4, width4, height4);
        btn_comp.setBounds(x4+1*(width4*1+5), y4, width4, height4);
        rbtn_8.setBounds(x4+2*(width4*1+5), y4, width4/3, height4/4);
        rbtn_16.setBounds(x4+2*(width4*1+5)+(int)width4/3, y4, width4/3, height4/4);
        rbtn_32.setBounds(x4+2*(width4*1+5)+(int)width4/3*2, y4, width4/3, height4/4);
        btn_clear.setBounds(x4+2*(width4+5), (int)(y4+0.33*height4), width4,(int)height4/3*2);

        int x5 = x4;
        int y5 = y4 + height4 + 10;
        int width5 = width4;
        int height5 = height4;
        btn_and.setBounds(x5, y5, width5, height5);
        btn_or.setBounds(x5+1*(width5+5), y5, width5, height5);
        btn_xor.setBounds(x5+2*(width5+5), y5, width5,height5);

        int x6 = x5;
        int y6 = y5 + height5 + 10;
        int width6 = width4;
        int height6 = height4;
        btn_plus.setBounds(x6, y6, width6, height6);
        btn_minus.setBounds(x6+1*(width6+5), y6, width6, height6);

        int x7 = x6;
        int y7 = y6 + height6 +10;
        int width7 = width6;
        int height7 = width7;
        btn_0.setBounds(x7, y7, width7, height7);
        btn_1.setBounds(x7+1*(width7+5), y7, width7, height7);

        btn_equal.setBounds(x6+2*(width6+5), y6, width6, height6+height7+10);

        // set the appearance
        btn_clear.setOpaque(true);
        btn_clear.setContentAreaFilled(false);
        rbtn_8.setOpaque(false);
        rbtn_8.setContentAreaFilled(false);
        rbtn_16.setOpaque(false);
        rbtn_16.setContentAreaFilled(false);
        rbtn_32.setOpaque(false);
        rbtn_32.setContentAreaFilled(false);

;
        //btnUI.paint(btn_0.getGraphics(), btn_0);
        jTextField.setOpaque(false);

        // add elements to panel
        jPanel.add(labelA);
        jPanel.add(labelC);
        jPanel.add(labelO);
        jPanel.add(labelP);
        jPanel.add(labelS);
        jPanel.add(labelZ);


        jPanel.add(jTextField);
        jPanel.add(lb_result);

        jPanel.add(rbtn_8);
        jPanel.add(rbtn_16);
        jPanel.add(rbtn_32);
        jPanel.add(btn_clear);

        jPanel.add(btn_not);
        jPanel.add(btn_comp);
        jPanel.add(btn_minus);

        jPanel.add(btn_and);
        jPanel.add(btn_or);
        jPanel.add(btn_xor);
        jPanel.add(btn_plus);

        jPanel.add(btn_0);
        jPanel.add(btn_1);
        jPanel.add(btn_equal);


        // set Background of panel
        jPanel.setBackground(Color.white);

        // add panel to frame
        jFrame.add(jPanel);

        jFrame.setVisible(true);
    }


    // Add zeros according to the set number of digits
    public String ZeroSupplement(String str, int binaryBits){
        String temp = str;
        // @SF is used to record whether it is negative
        boolean SF = false;
        if(temp.charAt(0) == '-'){
            SF = true;
            // delete the '-'
            temp = temp.substring(1);
        }
        for(int k = 0; k<binaryBits-str.length(); k++){
            temp='0'+temp;
        }
        if(SF){
            return ("-"+temp);
        }
        else {return temp;}
    }

    /*
    * showSignal
    * @param A 辅助进位(不考虑减法借位)
    * @param C 最高位产生进位
    * @param O 溢出
    * @param P =1最低8位1的个数为偶
    * @param S 运算结果的正负性（原码为最高位的值，但由于本计算机设计逻辑上以真值形式进行计算，需另行设计。=1为负）
    * @param Z =1运算结果为0
    *
    * Attention: When you use this function, you must place it before the statement that resets operand and operator
    * */
    //Display the six status flags of A, C, O, P, S, Z after operation
    public void showSignal(String result){

        if (result != "#"){
            String supplementaryOperand1 = ZeroSupplement(operand1,binaryBits);
            String supplementaryOperand2 = ZeroSupplement(operand2,binaryBits);
            String supplementaryResult = ZeroSupplement(result,binaryBits);

            int A=0;
            int C=0;
            int O=0;
            int P=0;
            int Z=1;
            int S=0;

            // Determine the status symbol @S
            if(supplementaryResult.charAt(0)=='-') {
                S=1;
            }else{
                // @A and @C are only considered when is not negative
                // Determine the status symbol @A
                if(Long.parseLong(supplementaryOperand1.substring(binaryBits/2),2) + Long.parseLong(supplementaryOperand2.substring(binaryBits/2),2) > Math.pow(2,binaryBits/2)-1) { A=1; }

                // In order to determine the status symbol @C, create params to store the highest bits of the Operand and Result respectively
                int highestOperandBit = binaryBits, highestResultBit = binaryBits;
                for(int i=0, count=0; i<binaryBits; i++){
                    // Record the highest bit of operand 1 and operand 2
                    if(supplementaryOperand1.charAt(i) == '1') {
                        highestOperandBit = Math.min(i,highestOperandBit);
                    }else if(supplementaryOperand2.charAt(i) == '1') {
                        highestOperandBit = Math.min(i,highestOperandBit);
                    }
                    // Determine whether the highest bit is carried
                    if(supplementaryResult.charAt(i) == '1') {
                        highestResultBit = Math.min(i, highestResultBit);
                    }
                }
                if(highestResultBit < highestOperandBit) { C = 1; }
            }

            // Determine the status symbol @O
            if(Long.parseLong(supplementaryOperand1,2)+Long.parseLong(supplementaryOperand2,2) > Math.pow(2,binaryBits)-1
                || Long.parseLong(supplementaryOperand1,2)+Long.parseLong(supplementaryOperand2,2) < -(Math.pow(2,binaryBits)-1)) { O=1; }

            // Determine the status symbol @Z and @P
            for(int i=0, count=0;i<result.length();i++){
                if(result.charAt(i)=='1') {
                    count++;
                    Z=0;
                }
                // Execute when the loop is about to end
                if(result.length() == (i+1)) {
                    if (count % 2 == 0) {
                        P = 1;
                    }
                }
            }

            //set status
            if(A == 1){
                labelA.setFont(new Font("Concolas",Font.BOLD,20));
                labelA.setForeground(Color.red);
            }
            if(C == 1){
                labelC.setFont(new Font("Concolas",Font.BOLD,20));
                labelC.setForeground(Color.red);
            }
            if(O == 1){
                labelO.setFont(new Font("Concolas",Font.BOLD,20));
                labelO.setForeground(Color.red);
            }
            if(P == 1){
                labelP.setFont(new Font("Concolas",Font.BOLD,20));
                labelP.setForeground(Color.red);
            }
            if(Z == 1) {
                labelZ.setFont(new Font("Concolas", Font.BOLD, 20));
                labelZ.setForeground(Color.red);
            }
            if(S == 1) {
                labelS.setFont(new Font("Concolas",Font.BOLD,20));
                labelS.setForeground(Color.red);
            }

        }else{
            //if str="#", reset
            labelA.setFont(new Font("Concolas",Font.PLAIN,20));
            labelA.setForeground(Color.gray);
            labelC.setFont(new Font("Concolas",Font.PLAIN,20));
            labelC.setForeground(Color.gray);
            labelO.setFont(new Font("Concolas",Font.PLAIN,20));
            labelO.setForeground(Color.gray);
            labelP.setFont(new Font("Concolas",Font.PLAIN,20));
            labelP.setForeground(Color.gray);
            labelZ.setFont(new Font("Concolas", Font.PLAIN, 20));
            labelZ.setForeground(Color.gray);
            labelS.setFont(new Font("Concolas",Font.PLAIN,20));
            labelS.setForeground(Color.gray);
        }
    }

    public boolean LengthLimit(String str){
        if(str.length()== binaryBits) {
            JOptionPane.showMessageDialog(new JFrame(), "您输入的二进制数超过了所选的最大字长，请切换位数设置。", "警告",JOptionPane.WARNING_MESSAGE);
            return false;
        }else {
            return true;
        }
    }
    public boolean ErrorWarning(String str){
        JOptionPane.showMessageDialog(new JFrame(), str, "警告",JOptionPane.WARNING_MESSAGE);
        showSignal("#");
        jTextField.setText("");
        lb_result.setText("");
        operand1 = operator = operand2 = result = "";
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String btnTag = e.getActionCommand();
        boolean error = false;

        // if the value is a number
        if (btnTag.equals("0")||btnTag.equals("1")) {
            // if operand is present then add to second no
            if (!operator.equals("")&&!operator.equals("NOT")&&!operator.equals("COMP")) {
                if(LengthLimit(operand2)) {operand2 = operand2 + btnTag;}
            }
            else {
                if(LengthLimit(operand1)) {operand1 = operand1 + btnTag;}
            }
            // set the value of text
            jTextField.setText(operand1 + " " + operator + " " + operand2);
        }
        else if (btnTag.equals("CLR")) {
            // clear the one letter
            showSignal("#");
            operand1 = operator = operand2 = result = "";
            // set the value of text
            jTextField.setText("");
            lb_result.setText("");
        }
        else if (btnTag.charAt(0) == '=') {
            if((!operand1.equals("") && !operator.equals("") && !operand2.equals("")) || (!operand1.equals("") && operator.equals("") && operand2.equals(""))){
                // only @operand1 is obtained
                if(operand2.equals("")) {
                    result = Long.toBinaryString(Long.parseLong(operand1, 2));
                }
                // all three parameters are obtained
                if (operator.equals("+")) {
                    Long tempLong = Long.parseLong(operand1,2) + Long.parseLong(operand2,2);
                    if(tempLong < 0) {
                        result = "-" + Long.toBinaryString(Math.abs(tempLong));
                    } else {
                        result = Long.toBinaryString(tempLong);
                    }
                }
                else if (operator.equals("-")){
                    Long tempLong = Long.parseLong(operand1,2) - Long.parseLong(operand2,2);
                    if(tempLong < 0) {
                        result = "-" + Long.toBinaryString(Math.abs(tempLong));
                    } else {
                        result = Long.toBinaryString(tempLong);
                    }
                }else if (operator.equals("AND")) {
                    if(operand1.charAt(0) == '-') {
                        error = ErrorWarning("非法操作。");
                    }else{
                        result = Long.toBinaryString(Long.parseLong(operand1, 2) & Long.parseLong(operand2, 2));
                    }
                }else if (operator.equals("OR")) {
                    if(operand1.charAt(0) == '-') {
                        error = ErrorWarning("非法操作。");
                    }else{
                        result = Long.toBinaryString(Long.parseLong(operand1, 2) | Long.parseLong(operand2, 2));
                    }
                }else if (operator.equals("XOR")) {
                    if(operand1.charAt(0) == '-') {
                        error = ErrorWarning("非法操作。");
                    }else {
                        result = Long.toBinaryString(Long.parseLong(operand1, 2) ^ Long.parseLong(operand2, 2));
                    }
                }
                if(!error){
                    // set the value of text
                    if(operand2 == "") {
                        operand2="0";
                        jTextField.setText(ZeroSupplement(operand1,binaryBits) + " =");
                    }else{
                        jTextField.setText(ZeroSupplement(operand1,binaryBits) + " " + operator + " " + ZeroSupplement(operand2,binaryBits) + " =");
                    }
                    String tempStr = ZeroSupplement(result,binaryBits);
                    lb_result.setText(tempStr.substring(tempStr.length()-binaryBits));
                    showSignal(result);
                    operand1 = tempStr.substring(tempStr.length()-binaryBits);
                    operator = operand2 = result = "";
                }
            }else{
                error = ErrorWarning("非法输入");
            }
        }
        else if(btnTag.equals("NOT")){
            lb_result.setText("");
            if(!operand1.equals("")){
                if(operand1.charAt(0) == '-') {
                    error = ErrorWarning("操作数不符合要求，请输入源码形式。");
                }else{
                    if(operand1.length()<= binaryBits){
                        operand1 = ZeroSupplement(operand1, binaryBits);
                        StringBuilder strBuilder = new StringBuilder(operand1);
                        for(int i = 0; i< binaryBits; i++){
                            if(operand1.charAt(i)=='0') {
                                strBuilder.setCharAt(i,'1');
                            }else{
                                strBuilder.setCharAt(i,'0');
                            }
                        }
                        result=strBuilder.toString();
                    }
                    jTextField.setText("NOT " + operand1 + " =");
                    lb_result.setText(ZeroSupplement(result, binaryBits));
                    showSignal(result);
                    operand1 =result;
                    operator = operand2 = result = "";
                }
            }else{
                error = ErrorWarning("请先输入源码形式的操作数。");
            }
        }
        else if(btnTag.equals("COMP")){
            lb_result.setText("");
            if(!operand1.equals("")){
                if(operand1.charAt(0) == '-') {
                    error = ErrorWarning("操作数不符合要求，请输入原码形式。");
                }else{
                    if(operand1.length()<= binaryBits){
                        operand1 = ZeroSupplement(operand1, binaryBits);
                        if(operand1.charAt(0)=='0'){
                            result= operand1;
                        }else{
                            StringBuilder strBuilder = new StringBuilder(operand1);
                            for(int i = 1; i< binaryBits; i++){
                                if(operand1.charAt(i)=='0') {
                                    strBuilder.setCharAt(i,'1');
                                }else{
                                    strBuilder.setCharAt(i,'0');
                                }
                            }
                            result=Long.toBinaryString(Long.parseLong(strBuilder.toString(),2)+1);
                        }
                    }
                    jTextField.setText("COMP " + operand1 + " =");
                    String tempStr = ZeroSupplement(result,binaryBits);
                    lb_result.setText(tempStr.substring(tempStr.length()-binaryBits));
                    showSignal(result);
                    operand1 =tempStr.substring(tempStr.length()-binaryBits);
                    operator = operand2 = result = "";
                }
            }else{
                error = ErrorWarning("请先输入原码形式的操作数。");
            }
        }
        else if(btnTag.equals("8") || btnTag.equals("16") || btnTag.equals("32")){
            if(btnTag.equals("8")) {
                binaryBits =8;
                jTextField.setFont(new Font("Times New Roman", Font.ITALIC, 35));
                lb_result.setFont(new Font("Consolas", Font.BOLD, 70));
            }
            else if(btnTag.equals("16")) {
                binaryBits =16;
                jTextField.setFont(new Font("Times New Roman", Font.ITALIC, 25));
                lb_result.setFont(new Font("Consolas", Font.BOLD, 50));
            }
            else if(btnTag.equals("32")) {
                binaryBits =32;
                jTextField.setFont(new Font("Times New Roman", Font.ITALIC, 15));
                lb_result.setFont(new Font("Consolas", Font.BOLD, 28));
            }
        }
        else{
            // Judge the situation of "+" and "-"
            lb_result.setText("");
            if(operand1.equals("")){
                // when operand1 is forgot
                JOptionPane.showMessageDialog(new JFrame(), "非法输入！", "警告",JOptionPane.WARNING_MESSAGE);
                showSignal("#");
                jTextField.setText("");
                lb_result.setText("");
                operand1 = operator = operand2 = result = "";
            }else if (operator.equals("") || operand2.equals("")) {
                // if we change the operator before operand2 input
                operator = btnTag;
                showSignal("#");
            }else {
                // In continuous operation, let the result be operand1
                lb_result.setText("");
                if (operator.equals("+")) {
                    Long tempLong = Long.parseLong(operand1,2) + Long.parseLong(operand2,2);
                    if(tempLong < 0) {
                        result = "-" + Long.toBinaryString(Math.abs(tempLong));
                    } else {
                        result = Long.toBinaryString(tempLong);
                    }
                }
                else if (operator.equals("-")){
                    Long tempLong = Long.parseLong(operand1,2) - Long.parseLong(operand2,2);
                    if(tempLong < 0) {
                        result = "-" + Long.toBinaryString(Math.abs(tempLong));
                    } else {
                        result = Long.toBinaryString(tempLong);
                    }
                }else if (operator.equals("AND")) {
                    if(operand1.charAt(0) == '-') {
                        error = ErrorWarning("非法操作。");
                    }else{
                        result = Long.toBinaryString(Long.parseLong(operand1, 2) & Long.parseLong(operand2, 2));
                    }
                }else if (operator.equals("OR")) {
                    if(operand1.charAt(0) == '-') {
                        error = ErrorWarning("非法操作。");
                    }else{
                        result = Long.toBinaryString(Long.parseLong(operand1, 2) | Long.parseLong(operand2, 2));
                    }
                }else if (operator.equals("XOR")) {
                    if(operand1.charAt(0) == '-') {
                        error = ErrorWarning("非法操作。");
                    }else {
                        result = Long.toBinaryString(Long.parseLong(operand1, 2) ^ Long.parseLong(operand2, 2));
                    }
                }
                // convert it to string
                showSignal(result);
                operand1 = result;
                // place the operator
                operator = btnTag;
                // make the operand blank
                operand2 = result = "";
            }

            // reset the value of text
            jTextField.setText(operand1 + " " + operator + " " + operand2);
        }
    }
}
