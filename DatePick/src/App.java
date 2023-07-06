import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.Color;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

public class App extends JFrame implements ActionListener{

    JFrame hay = new JFrame();
    String strDate;
    JDatePickerImpl datePicker;
    Calendar cal;
    SimpleDateFormat format;
    JPanel panel;
    JPanel buttonPanel;
    JDatePanelImpl paneldate;
    JButton conbtn;


    App(){
        Calendar();
        panelbtn();
        
        hay.getContentPane();
        hay.setTitle("Schedule");
        hay.setResizable(false);
        hay.setSize(215, 124);
        hay.setLayout(null);

        hay.add(panel);
        hay.setVisible(true);

    }

    void panelbtn(){


        Calendar();

        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setBounds(0, 0, 200, 85);
        panel.add(datePicker);
    }

    void Calendar(){

        SqlDateModel model = new SqlDateModel();
        Properties p = new Properties();
        model.setSelected(true);
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        paneldate = new JDatePanelImpl(model,p);
        datePicker = new JDatePickerImpl(paneldate, new AbstractFormatter(){ 
            
            @Override
            public String valueToString(Object value) throws ParseException {

                // TODO Auto-generated method stub
                if(value != null)
                {
                cal = (Calendar)value;
                format = new SimpleDateFormat("MM-dd-yyyy");
                strDate = format.format(cal.getTime());
                cal.getTime();
                return strDate;
            }return "";
            }
            
            @Override
            public Object stringToValue(String text) throws ParseException {
                // TODO Auto-generated method stub
                return "";
            }
    
            });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
  
        }
}





