package com.zzk.snake.client;

import com.zzk.snake.constant.Constant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SnakeClientTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void paint() {
    }

    @org.junit.jupiter.api.Test
    void drawScore() {
    }

    @org.junit.jupiter.api.Test
    void inputScore() throws IOException {

        String str = "650";
        try{
            if(str!="0")
            {System.out.println("YES");}

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO");
        }
    }
}