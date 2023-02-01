package main;
import exceptions.*;
import matrix.*;

public class lab3 {
	public static void main (String[] args) {
		Matrix m1 = new Matrix (4, 5);
		Matrix m2 = new Matrix (5, 4);
		try {
			m1.setElement (0, 1, 12);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m1.setElement (1, 0, 33);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {	
			m1.setElement (0, 3, 13);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m1.setElement (1, 4, 3);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m2.setElement (1, 0, 10);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m2.setElement (1, 2, 100);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m2.setElement (2, 2, 76);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m2.setElement (4, 0, 666);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		System.out.println ("matrix 1:" + m1.toString ());
		System.out.println ("matrix 2:" + m2.toString ());
		try {
			System.out.println ("prod:" + m1.product (m2).toString ());
		}
		catch (WrongMatrixSizeException e) {
			System.out.println (e.getMessage ());
		}
		SquareMatrix m3 = new SquareMatrix (3);
		SquareMatrix m4 = new SquareMatrix (3);
		try {
			m3.setElement (0, 1, 566);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m3.setElement (1, 2, 101);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m4.setElement (2, 1, 66);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m4.setElement (1, 2, 20);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		try {
			m4.setElement (0, 2, 22);
		}
		catch (WrongMatrixIndexException e) {
			System.out.println (e.getMessage ());
		}
		System.out.println ("Square matrix 1:" + m3.toString ());
		System.out.println ("Square matrix 2:" + m4.toString ());
		try {
			System.out.println("sum:" + m3.sum (m4).toString ());
		}
		catch (WrongMatrixSizeException e) {
			System.out.println (e.getMessage ());
		}
		try {
			System.out.println("prod:" + m3.product (m4).toString ());
		}
		catch (WrongMatrixSizeException e) {
			System.out.println (e.getMessage ());
		}
		Matrix m5 = new Matrix (9, 10);
		try {
			System.out.println (m5.product (m2).toString ());
		}
		catch (WrongMatrixSizeException e) {
			System.out.println (e.getMessage ());
		}
		SquareMatrix m6 = new SquareMatrix(2);
		Matrix m7 = new Matrix(2, 2);
		m7.setElement(0, 0, 1);
		m7.setElement(1, 1, 1);
		System.out.println(m7.equals(m6));
		System.out.println("sum:" + m6.sum (m7).toString ());


	}
}