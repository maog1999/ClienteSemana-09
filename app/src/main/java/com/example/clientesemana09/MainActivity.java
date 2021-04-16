package com.example.clientesemana09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private ImageView cereal, jugos, sandwich, perros;
    DatagramSocket socket;
     int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cereal = findViewById(R.id.cereal);
        jugos = findViewById(R.id.jugos);
        sandwich = findViewById(R.id.sandwich);
        perros = findViewById(R.id.perros);

        new Thread(

                () -> {

                    try {
                        socket = new DatagramSocket(6000);

                        //Recepción
                        while (true) {
                            byte[] buff = new byte[256];
                            DatagramPacket packet = new DatagramPacket(buff, buff.length);

                            System.out.println("Esperando");
                            socket.receive(packet);
                            String recibido = new String(packet.getData()).trim();
                            System.out.println(recibido);

                            runOnUiThread(
                                    () -> {

                                        Toast.makeText(this, recibido, Toast.LENGTH_LONG).show();
                                    }

                            );
                        }
                    } catch (SocketException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }).start();

        cereal.setOnClickListener(

                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);
                                    contador ++;
                                    if(contador >=5){
                                    runOnUiThread(
                                            () -> {

                                                Toast.makeText(this, "No se reciben más pedidos", Toast.LENGTH_SHORT).show();
                                            }

                                    );
                                    }
                                    String mensaje = "cereal";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"), 5000);

                                            socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

        sandwich.setOnClickListener(
                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);
                                    contador ++;
                                    if(contador >=5){
                                        runOnUiThread(
                                                () -> {

                                                    Toast.makeText(this, "No se reciben más pedidos", Toast.LENGTH_SHORT).show();
                                                }

                                        );
                                    }
                                    String mensaje = "sandwich";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"), 5000);

                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

        jugos.setOnClickListener(
                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);
                                    contador ++;
                                    if(contador >=5){
                                        runOnUiThread(
                                                () -> {

                                                    Toast.makeText(this, "No se reciben más pedidos", Toast.LENGTH_SHORT).show();
                                                }

                                        );
                                    }
                                    String mensaje = "jugos";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"), 5000);

                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

        perros.setOnClickListener(
                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);
                                    contador ++;
                                    if(contador >=5){
                                        runOnUiThread(
                                                () -> {

                                                    Toast.makeText(this, "No se reciben más pedidos", Toast.LENGTH_SHORT).show();
                                                }

                                        );
                                    }
                                    String mensaje = "perros";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"), 5000);

                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );
    }
}