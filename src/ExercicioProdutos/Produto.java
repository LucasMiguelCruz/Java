package ExercicioProdutos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
public class Produto {
    private JTextField textFieldQuantidade;
    private JTextField textFieldPreço;
    private JTextField textFieldNomeProduto;
    private JButton guardarButton;
    private JPanel PanelProduto;
    private JButton apagarButton;
    private JButton atualizarButton;
    private JButton procurarButton;
    private JTextField textFieldIDProduto;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldCategoria;
    private JTextArea textAreaProdutos;
    private JTextArea textAreaCategorias;
    private JTextField textFieldIDCategoria;
    private JButton apagarCategoriaButton;
    private JButton inserirCategoriaButton;
    private JButton procurarCategoriaButton;
    private JTextField textFieldNomeCategoria;
    private JTextArea textAreaProdutosCategoria;
    private JButton buttonProcurarImagem;
    private JLabel labelImagem;
    private JTextField textFieldIDImagem;
    private JTextField textFieldNomeImagem;
    private JTextField textFieldPreçoImagem;
    private JTextField textFieldQuantidadeImagem;
    private JTextField textFieldCategoriaImagem;
    private JLabel labelFoto;
    private JButton buttonPrimeiro;
    private JButton buttonAnterior;
    private JButton buttonProximo;
    private JButton buttonUltimo;

    Connection con;
    PreparedStatement pst;
    public String name,price,qty,cat;
    private String path=null;
    private byte[] userImage;
    private ResultSet rs;
    private Statement st;

    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bdlojalucas", "root","1234");
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select ID,NomeProd,Preço,Quantidade,Categoria,Foto from produtos");
            System.out.println("Success");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void setVisible(boolean b) {
        JFrame frame = new JFrame("Produto");
        frame.setContentPane(new Produto().PanelProduto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
    public Produto() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = textFieldNomeProduto.getText();
                price = textFieldPreço.getText();
                qty = textFieldQuantidade.getText();
                cat = textFieldCategoria.getText();

                try {
                    con = Conexao.createConnection();

                    PreparedStatement pst = con.prepareStatement("insert into produtos(NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA,FOTO)values(?,?,?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4,cat);
                    pst.setBytes(5,userImage);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldCategoria.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldCategoria.setText("");
                    labelImagem.setIcon(null);

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        procurarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pid = textFieldIDProduto.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA,FOTO from produtos where id = ?");
                    pst.setString(1, pid);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                        String name = rs.getString(1);
                        String price = rs.getString(2);
                        String qty = rs.getString(3);
                        String cat = rs.getString(4);
                        Blob blob = rs.getBlob(5);
                        byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                        ImageIcon imgIcon = new ImageIcon(new
                                ImageIcon(imageBytes).getImage().getScaledInstance(250, 250,
                                Image.SCALE_DEFAULT));
                        userImage = blob.getBytes(1, (int) blob.length());
                        labelImagem.setIcon(imgIcon);
                        textFieldNomeProduto.setText(name);
                        textFieldPreço.setText(price);
                        textFieldQuantidade.setText(qty);
                        textFieldCategoria.setText(cat);
                    }
                    else
                    {
                        textFieldNomeProduto.setText("");
                        textFieldPreço.setText("");
                        textFieldQuantidade.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Product ID");
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid,name,price,qty,cat;

                name = textFieldNomeProduto.getText();
                price = textFieldPreço.getText();
                qty = textFieldQuantidade.getText();
                pid = textFieldIDProduto.getText();
                cat = textFieldCategoria.getText();


                try {
                    PreparedStatement pst = con.prepareStatement("update produtos set NOMEPROD = ?,PREÇO = ?,QUANTIDADE = ?, CATEGORIA = ?, FOTO = ? where ID = ?");
                    pst.setString(1, name);
                    pst.setString(2, price);
                    pst.setString(3, qty);
                    pst.setString(4, cat);
                    pst.setBytes(5,userImage);
                    pst.setString(6, pid);




                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldIDProduto.setText("");
                    textFieldCategoria.setText("");
                    labelImagem.setIcon(null);

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid;

                bid = textFieldIDProduto.getText();
                try {
                    PreparedStatement pst = con.prepareStatement("delete from produtos where ID = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    textFieldNomeProduto.setText("");
                    textFieldPreço.setText("");
                    textFieldQuantidade.setText("");
                    textFieldNomeProduto.requestFocus();
                    textFieldIDProduto.setText("");
                    textFieldCategoria.setText("");
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });
        textAreaProdutos.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textAreaProdutos.setText("");
                try
                {
                    String pid = textFieldIDProduto.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMEPROD,PREÇO,QUANTIDADE,CATEGORIA from produtos ");
                    ResultSet rs = pst.executeQuery();
                    while (rs.next())
                    {
                        String name = rs.getString(1);
                        String price = rs.getString(2);
                        String qty = rs.getString(3);
                        String cat = rs.getString(4);

                        textAreaProdutos.append("\n Nome:  " + name + "\n Preço : " + price + "\n Quantidade: " +  qty + "\n Categoria: " + cat + "\n\n");

                    }



                }catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }

        });
        textAreaCategorias.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textAreaCategorias.setText("");
                try
                {
                    String pid = textFieldIDCategoria.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMECAT from categorias ");
                    ResultSet rs = pst.executeQuery();
                    while (rs.next())
                    {
                        String cat = rs.getString(1);
                        textAreaCategorias.append("Categoria:  " + cat + "\n\n");
                    }



                }catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        procurarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String cid = textFieldIDCategoria.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMEPROD from produtos JOIN CATEGORIAS ON PRODUTOS.CATEGORIA = CATEGORIAS.ID where CATEGORIAS.ID = ?");
                    pst.setString(1, cid);
                    ResultSet rs = pst.executeQuery();
                    textAreaProdutosCategoria.setText("");
                    while (rs.next()==true)
                    {
                        String nomeCat = rs.getString(1);
                        textAreaProdutosCategoria.append(nomeCat + "\n");
                    }

                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                try {
                    String cid = textFieldIDCategoria.getText();
                    con = Conexao.createConnection();
                    PreparedStatement pst = con.prepareStatement("select NOMECAT from categorias where id = ?");
                    pst.setString(1, cid);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                         String nomeCat = rs.getString(1);
                        textFieldNomeCategoria.setText(nomeCat);
                    }
                    else
                    {
                        textFieldNomeCategoria.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Product ID");
                    }
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }

            }
        });
        apagarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid;

                bid = textFieldIDCategoria.getText();
                try {
                    PreparedStatement pst = con.prepareStatement("delete from categorias where ID = ?");
                    pst.setString(1, bid);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    textFieldNomeCategoria.setText("");

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        inserirCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nca = textFieldNomeCategoria.getText();

                try {
                    con = Conexao.createConnection();

                    PreparedStatement pst = con.prepareStatement("insert into categorias(NOMECAT)values(?)");
                    pst.setString(1, nca);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");
                    textFieldIDCategoria.setText("");
                    textFieldNomeCategoria.setText("");

                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }

            }
        });
        buttonProcurarImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser imgChooser=new JFileChooser();
                imgChooser.showOpenDialog(null);
                File file=imgChooser.getSelectedFile();
                path=file.getAbsolutePath();

                BufferedImage img;
                try{
                    //prepara a imagem para apresentar no icon da label
                    img= ImageIO.read(imgChooser.getSelectedFile());
                    ImageIcon imageIcon = new ImageIcon( new ImageIcon(img).getImage().getScaledInstance(400, 400, img.SCALE_DEFAULT));
                    labelImagem.setIcon(imageIcon);
                    //guardar a imagem na variavel byte[] userImage para
                    //ser depois guardada na base de dados
                    File image=new File(path);
                    FileInputStream fs=new FileInputStream(image);
                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    int nBytesRead=0;
                    while((nBytesRead=fs.read(buff)) != 1)
                    {
                        bos.write(buff, 0, nBytesRead);
                        userImage=bos.toByteArray();
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        Connect();
        buttonPrimeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    rs.first();
                    textFieldQuantidadeImagem.setText(String.valueOf(rs.getDouble("quantidade")));
                    textFieldIDImagem.setText(String.valueOf(rs.getInt("id")));
                    textFieldNomeImagem.setText(rs.getString("NomeProd"));
                    textFieldPreçoImagem.setText(String.valueOf(rs.getDouble("preço")));
                    textFieldCategoriaImagem.setText(rs.getString("categoria"));
                    Blob blob=rs.getBlob("foto");
                    byte[] imageBytes= blob.getBytes(1,(int)blob.length());
                    ImageIcon imageIcon=new ImageIcon(new ImageIcon(imageBytes).getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT));
                    labelFoto.setIcon(imageIcon);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        buttonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!rs.isFirst()) {
                        rs.previous();
                        textFieldQuantidadeImagem.setText(String.valueOf(rs.getDouble("quantidade")));
                        textFieldIDImagem.setText(String.valueOf(rs.getInt("id")));
                        textFieldNomeImagem.setText(rs.getString("NomeProd"));
                        textFieldPreçoImagem.setText(String.valueOf(rs.getDouble("preço")));
                        textFieldCategoriaImagem.setText(rs.getString("categoria"));
                        Blob blob = rs.getBlob("foto");
                        byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageBytes).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                        labelFoto.setIcon(imageIcon);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        buttonProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!rs.isLast()) {
                        rs.next();
                        textFieldQuantidadeImagem.setText(String.valueOf(rs.getDouble("quantidade")));
                        textFieldIDImagem.setText(String.valueOf(rs.getInt("id")));
                        textFieldNomeImagem.setText(rs.getString("NomeProd"));
                        textFieldPreçoImagem.setText(String.valueOf(rs.getDouble("preço")));
                        textFieldCategoriaImagem.setText(rs.getString("categoria"));
                        Blob blob = rs.getBlob("foto");
                        byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageBytes).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                        labelFoto.setIcon(imageIcon);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        buttonUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                        rs.last();
                        textFieldQuantidadeImagem.setText(String.valueOf(rs.getDouble("quantidade")));
                        textFieldIDImagem.setText(String.valueOf(rs.getInt("id")));
                        textFieldNomeImagem.setText(rs.getString("NomeProd"));
                        textFieldPreçoImagem.setText(String.valueOf(rs.getDouble("preço")));
                        textFieldCategoriaImagem.setText(rs.getString("categoria"));
                        Blob blob = rs.getBlob("foto");
                        byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageBytes).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
                        labelFoto.setIcon(imageIcon);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

}

