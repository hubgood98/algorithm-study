package com.awt.study;

import java.awt.*;
import java.awt.event.*;

public class FrameDemo{

    public static class MyCanvas extends Canvas {
        private int x1 = 20, y1 = 20, x2 = 120, y2 = 100; // 초기값 설정

        public void setLine(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            repaint(); // 새로운 직선을 그리기 위해 다시 그리기 요청
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawLine(x1, y1, x2, y2);

            g.fillArc(100, 100, 100, 100, 50, 100);
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. Frame 만들기
        Frame frame = new Frame("직선을 그려보자!!!");

        frame.setSize(800, 600); // 2. Frame의 크기를 지정한다.
        MyCanvas canvas = new MyCanvas(); // 캔버스 추가
        frame.add(canvas);
        frame.setVisible(true); // Frame을 보여 준다

        // 좌표를 입력받을 텍스트 필드 생성
        TextField x1Field = new TextField(5);
        TextField y1Field = new TextField(5);
        TextField x2Field = new TextField(5);
        TextField y2Field = new TextField(5);

        // 프레임에 텍스트 필드와 버튼 추가
        Panel inputPanel = new Panel();
        inputPanel.add(new Label("x1: "));
        inputPanel.add(x1Field);
        inputPanel.add(new Label("y1: "));
        inputPanel.add(y1Field);
        inputPanel.add(new Label("x2: "));
        inputPanel.add(x2Field);
        inputPanel.add(new Label("y2: "));
        inputPanel.add(y2Field);
        frame.add(inputPanel, BorderLayout.NORTH); // 텍스트 필드를 북쪽에 추가

        Button button = new Button("직선 그리기");
        frame.add(button, BorderLayout.SOUTH); // 버튼을 남쪽에 추가

        // 버튼 클릭 이벤트 처리
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // 텍스트 필드에서 좌표값을 가져와서 직선을 설정
                    int x1 = Integer.parseInt(x1Field.getText());
                    int y1 = Integer.parseInt(y1Field.getText());
                    int x2 = Integer.parseInt(x2Field.getText());
                    int y2 = Integer.parseInt(y2Field.getText());
                    canvas.setLine(x1, y1, x2, y2);
                } catch (NumberFormatException ex) {
                    System.out.println("올바르지 않은 입력입니다.");
                }
            }
        });

        // 프로그램 종료 시, 프레임을 닫도록 설정
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}

