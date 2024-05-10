
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author > Silva, Algisi, Gaiotto
 * @version 1.0
 */
public final class Slot extends javax.swing.JFrame {

    private SlotGame s;                 //Variabile di tipo SlotGame che indica la slot
    private Timer t;                    //Variabile di supporto per l'animazione delle estrazioni
    private int a, i = 0;               //Variabili di supporto
    private boolean busy = false;       //Variabile per capire se il tasto è gia stato premuto
    private boolean canPlay = false;    //Variabile tramite la quale capisco se ho credito a sufficenza per giocare

    /**
     * Costruttore della slot, inizializza anche la grafica
     */
    public Slot() {

        s = new SlotGame();             //Creo la slot
        boolean valido = false;         //Variabile di supporto per fare il controllo dell'input

        do {
            try {
                //Leggo l'input da tastiera
                String credito = JOptionPane.showInputDialog(rootPane, "Credito iniziale", "100");

                //Se credito è null l'utente ha premuto il tasto cancel o exit chiudo il programma
                if (credito == null) {
                    System.exit(0);
                }

                //Imposto la somma al valore inserito
                s.setSomma(Integer.parseInt(credito));
                if (s.getSomma() <= 0) {
                    throw new Exception("Il valore è minore di 0!");
                } else if (s.getSomma() > 500) {
                    throw new Exception("Valore maggiore di 500!");
                }
                valido = true;
            } catch (Exception e) {

                switch (e.getMessage()) {
                    //Distinguo diversi errori: minore di 0, maggiore di 500 e errore generico
                    case "Valore maggiore di 500!" -> JOptionPane.showMessageDialog(rootPane, "Valore maggiore di 500!!");
                    case "Il valore è minore di 0!" -> JOptionPane.showMessageDialog(rootPane, "Valore minore di 0!!");
                    default -> {
                        //Se l'input non è valido lo richiedo nuovamente
                        JOptionPane.showMessageDialog(rootPane, "Input non valido");
                        valido = false;
                    }
                }
            }

            //Richiedo l'input fino a quando non è valido
        } while (!valido);

        //Inizializzo i componenti grafici
        initComponents();

        //Estraggo una combinazione iniziale casuale e la visualizzo
        s.estrai_inizio();
        a = s.getComb(0);
        img1.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
        a = s.getComb(1);
        img2.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
        a = s.getComb(2);
        img3.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));

        //Mostro a schermo la somma e il jackpot
        out_credito.setText("" + s.getSomma());
        out_jackpot.setText("" + s.getJackpot());
    }

    /**
     * Metodo che permette di aggiornare i punteggi, verificando l'eventuale
     * vincita
     */
    public void aggiornaPunteggi() {

        //Verifico se è stato vinto il jackpot
        if (s.vintoJackpot()) {

            //Stampo a schermo la vincita e aggiorno: credito e jackpot
            JOptionPane.showMessageDialog(rootPane, "JACKPOT!! Hai vinto: " + s.getJackpot() + "!!", "JACKPOT", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("Jackpot_win.jpg")));
            s.setSomma(s.getSomma() + s.getJackpot());
            s.setJackpot(100);

            //Verifico se è stata vinto una combinazione senza jackpot
        } else if (s.vintoComb() && !s.vintoJackpot()) {

            //Verifico la giocata impostata
            switch (giocata.getSelectedIndex()) {
                case 0 -> {
                    //Giocata 1
                    JOptionPane.showMessageDialog(rootPane, "Hai vinto: 10€", "VINCITA", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("Normal_win.jpg")));
                    s.setSomma(s.getSomma() + 10);
                }
                case 1 -> {
                    //Giocata 5
                    JOptionPane.showMessageDialog(rootPane, "Hai vinto: 50€", "VINCITA", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("Normal_win.jpg")));
                    s.setSomma(s.getSomma() + 50);
                }
                case 2 -> {
                    //Giocata 10
                    JOptionPane.showMessageDialog(rootPane, "Hai vinto: 100€", "VINCITA", JOptionPane.OK_OPTION, new ImageIcon(getClass().getResource("Normal_win.jpg")));
                    s.setSomma(s.getSomma() + 100);
                }
            }
        }

        //Visualizzo i valori aggiornati
        out_credito.setText("" + s.getSomma());
        out_jackpot.setText("" + s.getJackpot());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        giocata = new javax.swing.JComboBox<>();
        out_credito = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        out_jackpot = new javax.swing.JLabel();
        tira = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Background = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("100");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        jPanel1.setOpaque(false);

        img1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGO_1.png"))); // NOI18N

        img2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGO_3.png"))); // NOI18N

        img3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGO_1.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Credito: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Giocata:");

        giocata.setBackground(new java.awt.Color(255, 204, 51));
        giocata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 €", "5 €", "10 €" }));

        out_credito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        out_credito.setForeground(java.awt.Color.white);
        out_credito.setText("100");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Jackpot: ");

        out_jackpot.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        out_jackpot.setForeground(java.awt.Color.white);
        out_jackpot.setText("100");

        tira.setBackground(new java.awt.Color(255, 204, 51));
        tira.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        tira.setText("TIRA");
        tira.setBorder(null);
        tira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(out_jackpot, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(tira, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(giocata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(out_credito, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(giocata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tira, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(out_jackpot, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))))
        );

        jLayeredPane1.add(jPanel1);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BACKGROUND.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanel3);

        getContentPane().add(jLayeredPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiraActionPerformed

        //Verifico che il credito sia diverso da 0
        if (s.getSomma() == 0) {

            //Mostro l'avviso di Credito finito e termino
            JOptionPane.showMessageDialog(rootPane, "Credito finito!!");
            dispose();
        } else {
            //il credito è maggiore di 0
            do {
                //Verifico se è possibile eseguire 5 euro di giocata
                if (giocata.getSelectedIndex() == 1 && s.getSomma() - 5 < 0) {

                    //Mostro il messaggio di credito insufficente
                    JOptionPane.showMessageDialog(rootPane, "Credito insufficente: Abbassare la puntata!!");
                    return;

                    //Verifico se è possibile eseguire 10 euro di giocata
                } else if (giocata.getSelectedIndex() == 2 && s.getSomma() - 10 < 0) {

                    //Mostro il messaggio di credito insufficente
                    JOptionPane.showMessageDialog(rootPane, "Credito insufficente: Abbassare la puntata!!");
                    return;

                    //La puntata è minore del credito rimanente continuo a giocare
                } else {
                    canPlay = true;
                }

                //continua fino a quando il credito non è abbastanza per compiere la giocata
            } while (canPlay == false);

            //controllo se il bottone "TIRA" è gia stato premuto, in modo da non far ripartire nuovamente il timer
            if (busy) {
                return;
            } else {
                busy = true;
            }

            //Estraggo la combinazione vincente
            s.estrai(giocata.getSelectedIndex());

            //Stampo a schermo il jackpot e il credito aggiornati
            out_credito.setText("" + s.getSomma());
            out_jackpot.setText("" + s.getJackpot());

            t = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (i < 10) {

                        //Nelle prime 10 volte genera 3 combinazioni casuali
                        a = s.estraiValore();
                        img1.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.estraiValore();
                        img2.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.estraiValore();
                        img3.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        i++;
                    } else if (i < 15) {

                        //Fino alla 15esima volta la prima immagine è gia quella finale, genera casualmente le altre due combinazioni
                        a = s.getComb(0);
                        img1.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.estraiValore();
                        img2.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.estraiValore();
                        img3.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        i++;
                    } else if (i < 20) {

                        //Fino alla 20esima volta le prime due immagini sono quelle vincenti, genera casualmente solo l'ultima
                        a = s.getComb(0);
                        img1.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.getComb(1);
                        img2.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.estraiValore();
                        img3.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        i++;
                    } else {

                        //A partire dalla 20esima volta vengono mostrate tutte e 3 le immagini estratte
                        a = s.getComb(0);
                        img1.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.getComb(1);
                        img2.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));
                        a = s.getComb(2);
                        img3.setIcon(new ImageIcon(getClass().getResource("LOGO_" + a + ".png")));

                        //Azzero il contatore del timer
                        i = 0;

                        //Aggiorno il valore del punteggio verificando la vincita
                        aggiornaPunteggi();

                        //imposto la variabile busy a false in modo da poter schiacciare nuovamete il pulsante "TIRA"
                        busy = false;

                        //Fermo il timer
                        t.stop();
                    }
                }
            });

            //Faccio partire il timer
            t.start();
        }
    }//GEN-LAST:event_tiraActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        //Al tentativo di chiusura del programma compare un messaggio che ci permette di scegliere se ritirare i soldi o continuare
        int ret = JOptionPane.showConfirmDialog(rootPane, "RItirare: " + s.getSomma() + "?", "SLOT", JOptionPane.YES_NO_OPTION);

        //Verifico la scelta
        if (ret == JOptionPane.YES_OPTION) {

            //Se viene premuto YES termino
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Slot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Slot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Slot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Slot.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Slot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JComboBox<String> giocata;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel out_credito;
    private javax.swing.JLabel out_jackpot;
    private javax.swing.JButton tira;
    // End of variables declaration//GEN-END:variables
}
