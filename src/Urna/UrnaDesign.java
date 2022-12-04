package Urna;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class UrnaDesign extends javax.swing.JFrame {

    String slotText1 = "";
    String slotText2 = "";
    String strnum = "";
    String NumeroDigitado = "";
    int botaoBranco = 0, botaoNulo = 0;
    int votoBrancoGov = 0, votonulogov = 0, votonulopres = 0, votoBrancoPres = 0;
    int voto10 = 0, voto11 = 0, voto44 = 0, voto33 = 0;
    boolean imgTela = false;

    public UrnaDesign() {
        setResizable(false);
        setTitle("Urna Eletrônica");
        initComponents();
        ImagemLogoRep();
        jPanel3.setVisible(false);
        jLabel1.setVisible(false);

    }

    public void AudioPlay() {
        Clip clip;
        String name = "AudioUrna.wav";
        try {
            File file = new File(getClass().getResource(name).getFile());
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip line = (Clip) AudioSystem.getLine(info);
            line.open(stream);
            line.setLoopPoints(0, -1);
            clip = line;

        } catch (Throwable ex) {
            throw new Error(ex.getMessage());
        }
        clip.start();
        try {
            Thread.sleep(800);
        } catch (InterruptedException ex) {
            Logger.getLogger(UrnaDesign.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private void Corrigir() {
        strnum = "";
        caixaTexto1.setText("");
        caixaTexto2.setText("");
        caixaTexto1.grabFocus();
        jPanel3.setVisible(false);
        jLabel1.setVisible(false);
        botaoBranco = 0;
        botaoNulo = 0;
        imgTela = false;
        caixaTexto2.setEnabled(true);
    }

    public void ImagemLogoRep() {
        ImageIcon imgRep = new ImageIcon(getClass().getResource("justiça eleitoral.png"));
        jLabel2.setIcon(new ImageIcon(imgRep.getImage().getScaledInstance(100, 85, Image.SCALE_SMOOTH)));
    }

    private void ImagemPainel() {
        if (strnum.equals("10") && jlblcargo.getText().equals("GOVERNADOR")) {
            ImageIcon imgGov1 = new ImageIcon(getClass().getResource("Gov10.jpeg"));
            jLabel1.setIcon(new ImageIcon(imgGov1.getImage().getScaledInstance(930, 530, Image.SCALE_SMOOTH)));
            imgTela = true;

        } else if (strnum.equals("11") && jlblcargo.getText().equals("GOVERNADOR")) {
            ImageIcon imgGov2 = new ImageIcon(getClass().getResource("Gov11.jpeg"));
            jLabel1.setIcon(new ImageIcon(imgGov2.getImage().getScaledInstance(950, 530, Image.SCALE_SMOOTH)));
            imgTela = true;

        } else if (strnum.equals("44") && jlblcargo.getText().equals("PRESIDENTE")) {
            ImageIcon imgPres1 = new ImageIcon(getClass().getResource("Pres44.jpeg"));
            jLabel1.setIcon(new ImageIcon(imgPres1.getImage().getScaledInstance(950, 530, Image.SCALE_SMOOTH)));
            imgTela = true;

        } else if (strnum.equals("33") && jlblcargo.getText().equals("PRESIDENTE")) {
            ImageIcon imgPres2 = new ImageIcon(getClass().getResource("Pres33.jpeg"));
            jLabel1.setIcon(new ImageIcon(imgPres2.getImage().getScaledInstance(950, 530, Image.SCALE_SMOOTH)));
            imgTela = true;

        } else if (botaoBranco == 1) {
            ImageIcon imgBrancoG = new ImageIcon(getClass().getResource("Branco.jpeg"));
            jLabel1.setIcon(new ImageIcon(imgBrancoG.getImage().getScaledInstance(950, 530, Image.SCALE_SMOOTH)));
            imgTela = true;

        } else if (botaoNulo == 1) {
            ImageIcon imgNuloG = new ImageIcon(getClass().getResource("Nulo.jpeg"));
            jLabel1.setIcon(new ImageIcon(imgNuloG.getImage().getScaledInstance(950, 530, Image.SCALE_SMOOTH)));
            imgTela = true;

        } 
    }

    private void ImagemFim() {
        ImageIcon imgFim = new ImageIcon(getClass().getResource("9fim.png"));
        jLabel1.setIcon(new ImageIcon(imgFim.getImage().getScaledInstance(950, 530, Image.SCALE_SMOOTH)));
        imgTela = true;
    }
    
    private void EntradaNumero(String numero) {

        if (caixaTexto1.getText().equals("")) {
            caixaTexto1.setText(numero);
            caixaTexto2.grabFocus();
        } else {
            caixaTexto2.setText(numero);
            strnum = caixaTexto1.getText() + "" + caixaTexto2.getText();
            if (jlblcargo.getText().equals("GOVERNADOR")) {
                if (strnum.equals("10")) {
                    jPanel4.setVisible(false);
                    jPanel3.setVisible(true);
                    jLabel1.setVisible(true);
                    ImagemPainel();

                } else if (strnum.equals("11")) {
                    jPanel4.setVisible(false);
                    jPanel3.setVisible(true);
                    jLabel1.setVisible(true);
                    ImagemPainel();
                } else {
                    botaoNulo = 1;
                    jPanel4.setVisible(false);
                    jPanel3.setVisible(true);
                    jLabel1.setVisible(true);
                    ImagemPainel();
                }

            } else if (jlblcargo.getText().equals("PRESIDENTE")) {
                if (strnum.equals("33")) {
                    jPanel4.setVisible(false);
                    jPanel3.setVisible(true);
                    jLabel1.setVisible(true);
                    ImagemPainel();
                } else if (strnum.equals("44")) {
                    jPanel4.setVisible(false);
                    jPanel3.setVisible(true);
                    jLabel1.setVisible(true);
                    ImagemPainel();
                } else {
                    botaoNulo = 1;
                    jPanel4.setVisible(false);
                    jPanel3.setVisible(true);
                    jLabel1.setVisible(true);
                    ImagemPainel();

                }
            }
        }
    }

    private void FimVotação() {

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja continuar votando?", "Continuar Votação", 0) == 1) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja exibir o relatório?", "Relatorio Votação", 0) == 0) {
                String relatorio = "Apuração dos votos\n\n" + "GOVERNADOR:" + "\nHomem de Ferro = " + voto10 + "\nCorringa = " + voto11 + "\nBrancos = " + votoBrancoGov + "\nNulos = " + votonulogov
                         + "\n\nPRESIDENTE:" + "\nSuperman = " + voto33 + "\nCapitão América = " + voto44 + "\nBrancos = " + votoBrancoPres + "\nNulos = " + votonulopres;  
                JOptionPane.showMessageDialog(rootPane, relatorio);
                dispose();
            } else {
                dispose();
            }
        } else {
            Corrigir();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn2 = new javax.swing.JButton();
        btnbranco = new javax.swing.JButton();
        btncorrigir = new javax.swing.JButton();
        btnconfirmar = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpFundo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlblnum = new javax.swing.JLabel();
        jlblcargo = new javax.swing.JLabel();
        caixaTexto1 = new javax.swing.JTextField();
        caixaTexto2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btn2.setBackground(new java.awt.Color(0, 0, 0));
        btn2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.setName("btn2"); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btnbranco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbranco.setText("BRANCO");
        btnbranco.setName("btnbranco"); // NOI18N
        btnbranco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrancoActionPerformed(evt);
            }
        });

        btncorrigir.setBackground(new java.awt.Color(255, 102, 0));
        btncorrigir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncorrigir.setText("CORRIGE");
        btncorrigir.setName("btncorrigir"); // NOI18N
        btncorrigir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncorrigirActionPerformed(evt);
            }
        });

        btnconfirmar.setBackground(new java.awt.Color(0, 204, 0));
        btnconfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnconfirmar.setText("CONFIRMA");
        btnconfirmar.setName("btnconfirmar"); // NOI18N
        btnconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmarActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(0, 0, 0));
        btn7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.setName("btn7"); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(0, 0, 0));
        btn9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.setName("btn9"); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(0, 0, 0));
        btn8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.setName("btn8"); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(0, 0, 0));
        btn4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.setName("btn4"); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(0, 0, 0));
        btn6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.setName("btn6"); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(0, 0, 0));
        btn5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.setName("btn5"); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(0, 0, 0));
        btn1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.setName("btn1"); // NOI18N
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn1MouseReleased(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(0, 0, 0));
        btn3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.setName("btn3"); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn0.setBackground(new java.awt.Color(0, 0, 0));
        btn0.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.setName("btn0"); // NOI18N
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnbranco, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncorrigir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbranco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncorrigir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Urna/justiça eleitoral.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("JUSTIÇA");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ELEITORAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        jpFundo.setBackground(new java.awt.Color(204, 204, 204));
        jpFundo.setMaximumSize(new java.awt.Dimension(690, 490));
        jpFundo.setMinimumSize(new java.awt.Dimension(690, 490));
        jpFundo.setName(""); // NOI18N
        jpFundo.setLayout(new java.awt.CardLayout());

        jlblnum.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 26)); // NOI18N
        jlblnum.setText("Número:");
        jlblnum.setToolTipText("");

        jlblcargo.setFont(new java.awt.Font("Yu Gothic UI", 0, 27)); // NOI18N
        jlblcargo.setText("GOVERNADOR");

        caixaTexto1.setEditable(false);
        caixaTexto1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 60)); // NOI18N
        caixaTexto1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        caixaTexto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaTexto1ActionPerformed(evt);
            }
        });

        caixaTexto2.setEditable(false);
        caixaTexto2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 60)); // NOI18N
        caixaTexto2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        caixaTexto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caixaTexto2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jlblnum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixaTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caixaTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jlblcargo)))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jlblcargo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixaTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caixaTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jlblnum, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(407, Short.MAX_VALUE))
        );

        jpFundo.add(jPanel4, "card2");

        jPanel3.setPreferredSize(new java.awt.Dimension(962, 576));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Urna/1.png"))); // NOI18N
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpFundo.add(jPanel3, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("2");
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btncorrigirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncorrigirActionPerformed
        Corrigir();
    }//GEN-LAST:event_btncorrigirActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("4");
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("6");
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("5");
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("1");
        }

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("3");
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("7");
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("8");
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("9");
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        if (imgTela == true) {
            caixaTexto2.setEnabled(false);
        } else {
            EntradaNumero("0");
        }
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnbrancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrancoActionPerformed
        if (imgTela == false) {
            botaoBranco = 1;
            jPanel4.setVisible(false);
            jPanel3.setVisible(true);
            jLabel1.setVisible(true);
            ImagemPainel();
            imgTela = true;
            caixaTexto2.setEnabled(true);
        }

    }//GEN-LAST:event_btnbrancoActionPerformed

    private void btnconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmarActionPerformed
        if (botaoNulo == 1 && jlblcargo.getText().equals("GOVERNADOR")) {
            votonulogov++;
            jlblcargo.setText("PRESIDENTE");
            Corrigir();
            imgTela = false;
            caixaTexto2.setEnabled(true);
            AudioPlay();
        } else if (botaoBranco == 1 && jlblcargo.getText().equals("GOVERNADOR")) {
            votoBrancoGov++;
            jlblcargo.setText("PRESIDENTE");
            Corrigir();
            imgTela = false;
            caixaTexto2.setEnabled(true);
            AudioPlay();
        } else if (botaoNulo == 1 && jlblcargo.getText().equals("PRESIDENTE")) {
            votonulopres++;
            jlblcargo.setText("GOVERNADOR");
            AudioPlay();
            Corrigir();
            jPanel4.setVisible(false);
            jPanel3.setVisible(true);
            jLabel1.setVisible(true);
            imgTela = false;
            caixaTexto2.setEnabled(true);
            ImagemFim();
            FimVotação();
        } else if (botaoBranco == 1 && jlblcargo.getText().equals("PRESIDENTE")) {
            votoBrancoPres++;
            jlblcargo.setText("GOVERNADOR");
            AudioPlay();
            Corrigir();
            jPanel4.setVisible(false);
            jPanel3.setVisible(true);
            jLabel1.setVisible(true);
            imgTela = false;
            caixaTexto2.setEnabled(true);
            ImagemFim();
            FimVotação();
        } else if (strnum.equals("10") && jlblcargo.getText().equals("GOVERNADOR")) {
            voto10++;
            jlblcargo.setText("PRESIDENTE");
            Corrigir();
            imgTela = false;
            caixaTexto2.setEnabled(true);
            AudioPlay();
        } else if (strnum.equals("11") && jlblcargo.getText().equals("GOVERNADOR")) {
            voto11++;
            jlblcargo.setText("PRESIDENTE");
            Corrigir();
            imgTela = false;
            caixaTexto2.setEnabled(true);
            AudioPlay();
        } else if (strnum.equals("33") && jlblcargo.getText().equals("PRESIDENTE")) {
            voto33++;
            jlblcargo.setText("GOVERNADOR");
            AudioPlay();
            Corrigir();
            jPanel4.setVisible(false);
            jPanel3.setVisible(true);
            jLabel1.setVisible(true);
            imgTela = false;
            caixaTexto2.setEnabled(true);
            ImagemFim();
            FimVotação();
        } else if (strnum.equals("44") && jlblcargo.getText().equals("PRESIDENTE")) {
            voto44++;
            jlblcargo.setText("GOVERNADOR");
            AudioPlay();
            Corrigir();
            jPanel4.setVisible(false);
            jPanel3.setVisible(true);
            jLabel1.setVisible(true);
            imgTela = false;
            caixaTexto2.setEnabled(true);
            ImagemFim();
            FimVotação();
        }
    }//GEN-LAST:event_btnconfirmarActionPerformed

    private void caixaTexto2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaTexto2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaTexto2KeyPressed

    private void caixaTexto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaTexto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaTexto1ActionPerformed

    private void btn1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1MouseReleased

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
            java.util.logging.Logger.getLogger(UrnaDesign.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrnaDesign.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrnaDesign.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrnaDesign.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrnaDesign().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnbranco;
    private javax.swing.JButton btnconfirmar;
    private javax.swing.JButton btncorrigir;
    private javax.swing.JTextField caixaTexto1;
    private javax.swing.JTextField caixaTexto2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlblcargo;
    private javax.swing.JLabel jlblnum;
    private javax.swing.JPanel jpFundo;
    // End of variables declaration//GEN-END:variables


}
