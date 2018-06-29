package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import server.Message;;

public class DataStore {

	Map<Date, Message> messageMap = new HashMap<>();
	
	int messageId = 0;
	
	Date now = new Date();
	long time = now.getTime();

	private Map<Date, Message> getMessageMap() {
		if (messageMap == null) {
			try {
				// Файл, у якому зберігається карта
				File file = new File("message.dat");
				if (!file.exists()) {
					// Якщо файлу нема, створюємо карту і файл
					Message mess = new Message("Hello");
					messageMap = new HashMap<>();
					messageMap.put(now, mess);
					saveMessageMap();
				} else {
					// Якщо файл є, завантажуємо карту
					FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis);
					messageMap = (Map<Date, Message>) ois.readObject();
					ois.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return messageMap;
	}

	private void saveMessageMap() {
		try {
			File file = new File("message.dat");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(messageMap);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------ Методи доступу до даних ---------//
	// Метод повернення переліку студентів
	public Collection<Message> getAllMessages() {
		return getMessageMap().values();
	}

	// Метод доступу до студента по заданому id
	public Message getMessage() {
		long time = 0;
		Message email;
		for(Map.Entry<Date, Message> mess : messageMap.entrySet()) {
			if(time < mess.getKey().getTime()) {
				time = mess.getKey().getTime();
				
			}
		//System.out.println("ID = " + mess.getKey().getTime() + " Value = " + mess.getValue());	
		}
		Date date = new Date(time);
		email = messageMap.get(date);
		return email;
	}

	// Метод, що додає студента до карти
	public int addMessage(Message email, Date date) {
		if (getMessageMap().containsKey(date))
			return 0;
		messageMap.put(date, email);
		saveMessageMap();
		return 1;
	}
}