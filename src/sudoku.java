import javax.swing.*;
import java.awt.*;

public class sudoku extends JDialog{
    private JPanel panelP ;
    private JPanel j11; private JPanel j12; private JPanel j13; private JPanel j14; private JPanel j15; private JPanel j16; private JPanel j17; private JPanel j18; private JPanel j19; private JPanel j1;
    private JLabel t11;private JLabel t12;private JLabel t13;private JLabel t14;private JLabel t15;private JLabel t16;private JLabel t17;private JLabel t18;private JLabel t19;

    private JPanel j31;private JLabel t31;private JLabel t32;private JPanel j32;private JPanel j34;private JPanel j37;private JPanel j35;private JPanel j38;private JPanel j36;private JPanel j33;private JPanel j39;
    private JLabel t39;private JLabel t33;private JLabel t36;private JLabel t34;private JLabel t37;private JLabel t35;private JLabel t38;private JPanel j3;private JPanel j211;private JLabel t21;private JPanel j221;
    private JPanel j231;private JPanel j241;private JPanel j251;private JPanel j261;private JPanel j271;private JPanel j281;private JPanel j291;
    private JLabel t22;private JLabel t23;private JLabel t24;private JLabel t25;private JLabel t26;private JLabel t27;private JLabel t28;private JLabel t29;
    private JPanel j2;private JPanel j4;private JPanel j5;private JPanel j6;private JPanel j7;private JPanel j8;private JPanel j9;
    private JPanel j41;private JPanel j42;private JPanel j44;private JPanel j45;private JPanel j43;private JPanel j46;private JPanel j48;private JPanel j49;private JPanel j47;
    private JLabel t41;private JLabel t42;private JLabel t44;private JLabel t45;private JLabel t43;private JLabel t46;private JLabel t49;private JLabel t48;private JLabel t47;private JPanel j51;
    private JPanel j52;private JPanel j53;private JPanel j54;private JPanel j55;private JPanel j56;private JPanel j57;private JPanel j58;private JPanel j59;
    private JLabel t51;private JLabel t52;private JLabel t54;private JLabel t57;private JLabel t53;private JLabel t55;private JLabel t56;private JLabel t58;private JLabel t59;
    private JPanel j61;private JPanel j62;private JPanel j63;private JPanel j64;private JPanel j65;private JPanel j66;private JPanel j67;private JPanel j68;private JPanel j69;
    private JLabel t61;private JLabel t62;private JLabel t64;private JLabel t65;private JLabel t63;private JLabel t67;private JLabel t68;private JLabel t66;private JLabel t69;
    private JPanel j71;private JPanel j72;private JPanel j74;private JPanel j75;private JPanel j77;private JPanel j78;private JPanel j76;private JPanel j73;private JPanel j79;
    private JLabel t71;private JLabel t72;private JLabel t74;private JLabel t75;private JLabel t77;private JLabel t78;private JLabel t76;private JLabel t73;private JLabel t79;
    private JPanel j81;private JPanel j82;private JPanel j83;private JPanel j84;private JPanel j85;private JPanel j86;private JPanel j87;private JPanel j88;private JPanel j89;
    private JLabel t81;private JLabel t82;private JLabel t83;private JLabel t87;private JLabel t88;private JLabel t89;private JLabel t86;private JLabel t85;private JLabel t84;
    private JPanel j91;private JPanel j92;private JPanel j94;private JPanel j97;private JPanel j93;private JPanel j95;private JPanel j96;private JPanel j98;private JPanel j99;
    private JLabel t91;private JLabel t92;private JLabel t94;private JLabel t97;private JLabel t93;private JLabel t95;private JLabel t96;private JLabel t98;private JLabel t99;
    private JButton button;
    private JPanel buttonPanel;
    private JLabel titulo;
    private JPanel tituloPanel;
    private static int [][] matrizOr;

    public sudoku() {
        setContentPane(panelP);
        JPanel [] paneles1 = new JPanel[] {j11,j12,j13,j14,j15,j16,j17,j18,j19};
        JLabel [] letras1 = new JLabel[] { t11,t12,t13,t14,t15,t16,t17,t18,t19};
        JPanel [] paneles2 = new JPanel[] {j211,j221, j231, j241,j251,j261,j271,j281,j291};
        JLabel [] letras2 = new JLabel[] {t21,t22,t23,t24,t25,t26,t27,t28,t29};
        JPanel [] paneles3 = new JPanel[] {j31,j32,j33,j34,j35,j36,j37,j38,j39};
        JLabel [] letras3 = new JLabel[] {t31,t32,t33,t34,t35,t36,t37,t38, t39};
        JPanel [] paneles4 = new JPanel[]{j41,j42,j43,j44,j45,j46,j47,j48,j49};
        JLabel [] letras4 = new JLabel[] {t41,t42,t43,t44,t45,t46,t47,t48, t49};
        JPanel [] paneles5 = new JPanel[]{j51,j52,j53,j54,j55,j56,j57,j58,j59};
        JLabel [] letras5 = new JLabel[]{t51,t52,t53,t54,t55,t56,t57,t58,t59};
        JPanel [] paneles6 = new JPanel[]{j61,j62,j63,j64,j65,j66,j67,j68,j69};
        JLabel [] letras6 = new JLabel[]{t61,t62,t63,t64,t65,t66,t67,t68,t69};
        JPanel [] paneles7 = new JPanel[]{j71,j72,j73,j74,j75,j76,j77,j78,j79};
        JLabel [] letras7 = new JLabel[]{t71,t72,t73,t74,t75,t76,t77,t78,t79};
        JPanel [] paneles8 = new JPanel[]{j81,j82,j83,j84,j85,j86,j87,j88,j89};
        JLabel [] letras8 = new JLabel[]{t81,t82,t83,t84,t85,t86,t87,t88,t89};
        JPanel [] paneles9 = new JPanel[]{j91,j92,j93,j94,j95,j96,j97,j98,j99};
        JLabel [] letras9 = new JLabel[]{t91,t92,t93,t94,t95,t96,t97,t98,t99};

        j1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        llenarPaneles(paneles1);
        addLetraToPanel(paneles1,letras1);
        llenarLetras(letras1);

        j2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        llenarPaneles(paneles2);
        addLetraToPanel(paneles2,letras2);
        llenarLetras(letras2);

        j3.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        llenarPaneles(paneles3);
        addLetraToPanel(paneles3,letras3);
        llenarLetras(letras3);

        j4.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        llenarPaneles(paneles4);
        addLetraToPanel(paneles4,letras4);
        llenarLetras(letras4);

        j5.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        llenarPaneles(paneles5);
        addLetraToPanel(paneles5,letras5);
        llenarLetras(letras5);

        j6.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        llenarPaneles(paneles6);
        addLetraToPanel(paneles6,letras6);
        llenarLetras(letras6);

        j7.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        llenarPaneles(paneles7);
        addLetraToPanel(paneles7,letras7);
        llenarLetras(letras7);

        j8.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        llenarPaneles(paneles8);
        addLetraToPanel(paneles8,letras8);
        llenarLetras(letras8);

        j9.setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
        llenarPaneles(paneles9);
        addLetraToPanel(paneles9,letras9);
        llenarLetras(letras9);

        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setText("Resolver");
        button.setBackground(Color.blue);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        button.setFont(new Font("Arial", Font.BOLD, 22));
        button.setForeground(Color.white);

        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("SUDOKU");
        titulo.setFont(new Font("Arial", Font.BOLD, 42));


    }

    public void llenarPaneles(JPanel [] paneles) {
        for (JPanel jPanel : paneles) {
            jPanel.setBorder(BorderFactory.createBevelBorder(0));
            jPanel.setBackground(Color.white);
            jPanel.setLayout(new BorderLayout());
        }
    }

    public void addLetraToPanel(JPanel [] paneles, JLabel [] letras) {
        for(int i=0;i<paneles.length;i++) {
            addLetraToPanel(paneles[i],letras[i]);
        }
    }

    public void addLetraToPanel (JPanel jPanel, JLabel jLabel){
        jPanel.add(jLabel, BorderLayout.CENTER);
    }

    public void llenarLetras(JLabel [] letras) {
        //Solo pruebas
        for(int i=0; i<letras.length; i++){
            letras[i].setText(1+i + "");
            letras[i].setVerticalAlignment(JLabel.CENTER);
            letras[i].setHorizontalAlignment(JLabel.CENTER);
            letras[i].setFont(new Font("Arial", Font.BOLD, 44));
        }
    }


    public static void display(int [][] matriz) {
        matrizOr = matriz;
        sudoku sudoku = new sudoku();
        sudoku.pack();
        sudoku.setSize(1300,800);
        sudoku.setLocationRelativeTo(null);
        sudoku.setAlwaysOnTop(true);
        sudoku.setVisible(true);
    }


}
