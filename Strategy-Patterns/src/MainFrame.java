import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by SunnyZheng on 3/20/16.
 */
public class MainFrame extends JFrame{
    private JLabel labelSelect;
    private JLabel labelNumber;
    private JLabel labelResult;
    private String str = "";//for storing the results

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

        setHashMapAndList(hmap, list);
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

            str = String.format("打折前价格为: %.2f, 打折后价格为: %.2f",
                     printer.originalPrice, printer.getRealPrice());
            textResult.setText(printer.getMessage(printer.printerName, printer.discountWay));
        }
    }
    public static void main(String[] args){
        new MainFrame();
    }
    public static void setHashMapAndList(HashMap<String, String> h, Vector<String> v){
        //
        h.put("佳能打印机", "CanonPrinter");
        h.put("爱普生打印机", "EpsonPrinter");
        h.put("惠普打印机", "HPPrinter");
        h.put("三星打印机", "SamsungPrinter");

        //handle comboBox's list
        for(HashMap.Entry<String, String> entry: h.entrySet()){
            v.add(entry.getKey());
        }
    }
}
