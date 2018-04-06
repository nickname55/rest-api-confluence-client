package com.pampushko.confluence.utils;

import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Утилиты для работы с файлами
 * <br>
 */
@Slf4j
public class FilesUtils
{
	
	/**
	 * Метод читает ResponseBody как последовательность байтов и записывает их в файл на диске
	 * <br>
	 * @param body - тело ответа
	 * @param directoryName - имя каталога в который мы хотим записать файл результата (<strong>без разделителя в конце</strong>)
	 * @param fileName - имя в который мы хотим поместить результат
	 * @return булево значение, если метод завершился успешно, то равно true
	 */
	public static boolean writeResponseBodyToDisk(ResponseBody body, final String directoryName, final String fileName)
	{
		
		try
		{
			// todo change the file location/name according to your needs
			File futureStudioIconFile = new File(directoryName + File.separator + fileName);
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			
			try
			{
				byte[] fileReader = new byte[4096];
				
				long fileSize = body.contentLength();
				long fileSizeDownloaded = 0;
				
				inputStream = body.byteStream();
				outputStream = new FileOutputStream(futureStudioIconFile);
				
				while (true)
				{
					int read = inputStream.read(fileReader);
					
					if (read == -1)
					{
						break;
					}
					
					outputStream.write(fileReader, 0, read);
					
					fileSizeDownloaded += read;
					
					log.debug("file download: " + fileSizeDownloaded + " of " + fileSize);
				}
				
				outputStream.flush();
				
				return true;
			}
			catch (IOException e)
			{
				return false;
			}
			finally
			{
				if (inputStream != null)
				{
					inputStream.close();
				}
				
				if (outputStream != null)
				{
					outputStream.close();
				}
			}
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	/**
	 * Создает временную директорию
	 * <br>
	 * и возвращает имя это директории (<strong>без разделителя в конце</strong>)
	 * <br>
	 * @return имя созданной директории
	 */
	public static String getExternalFilesDir()
	{
		String directoryName = Files.createTempDir().getPath();
		log.info("directory name {}", directoryName);
		return directoryName;
	}
	
	
	/**
	 * Метод получает на вход содержимое заголовка Content-Disposition
	 * <br>
	 * извлекает, предполагаемое имя файла из содержимого заголовка
	 * <br>
	 * и возвращает это имя файла
	 * <br>
	 * @param contentDispositionHeader
	 * @return строка- имя файла
	 */
	public static String getFileNameFromContentDispositionHeader(final String contentDispositionHeader)
	{
		String fileName = "noname";
		String[] strings = contentDispositionHeader.split(";");
		Optional<String> stringOptional = Stream.of(strings).filter(x -> x.contains("filename=")).findFirst();
		if (stringOptional.isPresent())
		{
			String string = stringOptional.get();
			String[] split = string.split("=");
			List<String> list = Arrays.asList(split);
			if (list.size() > 1)
			{
				fileName = list.get(1).replaceAll("\"", "");
				System.out.println(fileName);
			}
		}
		return fileName;
	}
}
