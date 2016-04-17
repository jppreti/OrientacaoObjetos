package br.edu.ifmt.cba.java.sound;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class OutStreamming {

	protected static boolean running;
	static ByteArrayOutputStream out;
	
	private static AudioFormat getFormat() {
		float sampleRate = 8000;
		int sampleSizeInBits = 8;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = true;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
				bigEndian);
	}

	public static void main(String[] args) {
		//--------------------------------------------------------------------------
		//------------------------CAPTURANDO O AUDIO--------------------------------
		//--------------------------------------------------------------------------
		try {
			final AudioFormat format = getFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			final TargetDataLine line = (TargetDataLine) AudioSystem
					.getLine(info);
			line.open(format);
			line.start();
			Runnable runner = new Runnable() {
				int bufferSize = (int) format.getSampleRate()
						* format.getFrameSize();
				byte buffer[] = new byte[bufferSize];

				public void run() {
					out = new ByteArrayOutputStream();
					running = true;
					try {
						while (running) {
							int count = line.read(buffer, 0, buffer.length);
							if (count > 0) {
								out.write(buffer, 0, count);
							}
						}
						out.close();
					} catch (IOException e) {
						System.err.println("I/O problems: " + e);
						System.exit(-1);
					}
				}
			};
			Thread captureThread = new Thread(runner);
			captureThread.start();
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable: " + e);
			System.exit(-2);
		}
				
		//--------------------------------------------------------------------------
		//------------------------TOCANDO O AUDIO-----------------------------------
		//--------------------------------------------------------------------------
		
		try {
			byte audio[] = out.toByteArray();
			InputStream input = new ByteArrayInputStream(audio);
			final AudioFormat format = getFormat();
			final AudioInputStream ais = new AudioInputStream(input, format,
					audio.length / format.getFrameSize());
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			final SourceDataLine line = (SourceDataLine) AudioSystem
					.getLine(info);
			line.open(format);
			line.start();

			Runnable runner = new Runnable() {
				int bufferSize = (int) format.getSampleRate()
						* format.getFrameSize();
				byte buffer[] = new byte[bufferSize];

				public void run() {
					try {
						int count;
						while ((count = ais.read(buffer, 0, buffer.length)) != -1) {
							if (count > 0) {
								line.write(buffer, 0, count);
							}
						}
						line.drain();
						line.close();
					} catch (IOException e) {
						System.err.println("I/O problems: " + e);
						System.exit(-3);
					}
				}
			};
			Thread playThread = new Thread(runner);
			playThread.start();
		} catch (LineUnavailableException e) {
			System.err.println("Line unavailable: " + e);
			System.exit(-4);
		}		
	}

}
