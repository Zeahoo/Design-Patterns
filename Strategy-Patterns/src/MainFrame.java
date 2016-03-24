import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by SunnyZheng on 3/20/16.
 */
public class MainFrame extends JFrame{

    private JLabel labelSelect;
    private JLabel labelNumber;

    private JTextArea textResult;

    private JComboBox comboBox;
    private Vector<String> list = new Vector<String>();
    private HashMap<String, String> hmap = new HashMap<String, String>();

    private JTextField textNumber;
    private JButton buttonConfirm;

    private Printer printer;

    public MainFrame(){
        super("打印机销售系统");
        setLayout(new FlowLayout());

        labelSelect = new JLabel("请选择打印机:");
        add(labelSelect);
        try{
            setHashMapAndList(hmap, list);
        }catch (Exception e){
            e.printStackTrace();
        }

        comboBox = new JComboBox(list);
        add(comboBox);

        labelNumber = new JLabel("请选择数量:");
        add(labelNumber);

        textNumber = new JTextField(4);
        add(textNumber);

        buttonConfirm = new JButton("确认");
        add(buttonConfirm);

        ButtonHandler handler = new ButtonHandler();
        buttonConfirm.addActionListener(handler);

//        labelResult = new JLabel();
//        add(labelResult);

        textResult = new JTextArea(5, 18);
        textResult.setEditable(false);
        textResult.setLineWrap(true);
        add(textResult);
        this.setSize(290,190);
        this.setVisible(true);
    }
    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String printerName = (String)comboBox.getSelectedItem();
            String printClass = hmap.get(printerName);
//            System.out.println(printClass);
            try{
                printer =(Printer) Class.forName(printClass).newInstance();
            }catch (Exception ex){
                ex.printStackTrace();
            }

            printer.quantity = Integer.valueOf(textNumber.getText());

            textResult.setText(printer.getMessage(printer.printerName, printer.discountWay));
        }
    }
    public static void main(String[] args){
        new MainFrame();
    }
    public static void setHashMapAndList(HashMap<String, String> h, Vector<String> v){
//        //
//        h.put("佳能打印机", "CanonPrinter");
//        h.put("爱普生打印机", "EpsonPrinter");
//        h.put("惠普打印机", "HPPrinter");
//        h.put("三星打印机", "SamsungPrinter");
//
//        //handle comboBox's list
//        for(HashMap.Entry<String, String> entry: h.entrySet()){
//            v.add(entry.getKey());
//        }
        try{

            FileReader fr = new FileReader("config.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while(true){
                line = br.readLine();
                if(line == null)
                    break;
                String[] sPrinter = line.split(" ");
                v.add(sPrinter[0]);
                h.put(sPrinter[0], sPrinter[1]);

            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
