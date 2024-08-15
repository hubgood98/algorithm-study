package com.homework;

import java.awt.Canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

public class HomeTree extends Canvas {

    private static final int Start_Length = 180;
    private static final int Last_Length = 10;
    private static final double TURN_ANGLE = Math.PI / 6; 

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Point startPoint = new Point(getHeight()/2,getWidth()); // 시작점
        double currentDirection =  3 * Math.PI / 2; // 초기 방향 (위쪽)

        drawLineRecursive(g, startPoint, Start_Length, currentDirection);
    }



    private void drawLineRecursive(Graphics g, Point startPoint, double length, double direction) {
        
        if (length < Last_Length) { // 선의 길이가 일정 길이보다 작으면 종료
            return; 
        }

        // 선 끝점 계산
        int endX = startPoint.x + (int)(length * Math.cos(direction));
        int endY = startPoint.y + (int)(length * Math.sin(direction));
        Point endPoint = new Point(endX, endY);

        // 선 그리기
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);

        // 방향 변경
        double leftAngle = direction - TURN_ANGLE; // 왼쪽으로 튼 방향
        double rightAngle = direction + TURN_ANGLE; // 오른쪽으로 튼 방향

        // 새로운 선 그리기
        drawLineRecursive(g, endPoint, length * 0.75, leftAngle);
        drawLineRecursive(g, endPoint, length * 0.75, rightAngle);
    }

    public static void main(String[] args) {

        //프레임 설정
        JFrame frame = new JFrame("나무만들기 첫번째 과제");
        homeTree canvas = new homeTree();
        frame.add(canvas);
        frame.setSize(850, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우를 닫을 때 프로그램이 종료되게하기(EXIT_ON_CLOSE)
        frame.setVisible(true);
    }
}

