import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl, titlePnl, displayPnl, controlPnl;
    JButton getFortuneBtn, quitBtn;
    JLabel titleLbl;
    ImageIcon icon;
    JTextArea fortuneTA;
    JScrollPane scroller;

    Random gen =  new Random();
    String[] fortunes = new String[12];
    String aFortune;
    int indexVal;
    int oldVal;

    public String getFortunes() {
        fortunes[0] = "You will fall in love at some point";
        fortunes[1] = "Your lucky colour is beige";
        fortunes[2] = "Something exciting is bound to happen on a Tuesday";
        fortunes[3] = "You will eat a hot dog soon";
        fortunes[4] = "You will make at least $1 this year";
        fortunes[5] = "Nothing remarkable will happen today";
        fortunes[6] = "The stars are in your favour";
        fortunes[7] = "Your next fart will be a shart";
        fortunes[8] = "Spaghetti will be on sale soon";
        fortunes[9] = "Your palms tell me they're sweaty";
        fortunes[10] = "You will get an A in this class";
        fortunes[11] = "AI will not take your job";

        indexVal = gen.nextInt(fortunes.length);
        indexVal += 1;

        aFortune = fortunes[indexVal];

        while(indexVal == oldVal) {
            indexVal = gen.nextInt(fortunes.length);
            indexVal += 1;
        }

        oldVal = indexVal;

        return aFortune;
    }

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel Assembly
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();
        setVisible(true);
    }

    private void createTitlePanel() {
        titlePnl = new JPanel();
        icon = new ImageIcon("src/FortuneTellerIcon.jpeg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new java.awt.Font("Times New Roman", 1, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);


    }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(10,45);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    private void createControlPanel() {
        controlPnl = new JPanel();
        getFortuneBtn = new JButton("Get Fortune");

        getFortuneBtn.addActionListener((ActionEvent ae) -> {
            System.out.println(getFortunes() + "\n");
            fortuneTA.append(getFortunes() + "\n");
        });
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(getFortuneBtn);
        controlPnl.add(quitBtn);

        mainPnl.add(controlPnl, BorderLayout.SOUTH);
    }
}
