package com.firsttask.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("books")
public class BookForCache implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  
	private int bookid;  
	private String bookname;  
	private String author;  
	private int price;  
	public int getBookid()   
	{  
	return bookid;  
	}  
	public void setBookid(int bookid)   
	{  
	this.bookid = bookid;  
	}  
	public String getBookname()  
	{  
	return bookname;  
	}  
	public void setBookname(String bookname)   
	{  
	this.bookname = bookname;  
	}  
	public String getAuthor()   
	{  
	return author;  
	}  
	public void setAuthor(String author)   
	{  
	this.author = author;  
	}  
	public int getPrice()   
	{  
	return price;  
	}  
	public void setPrice(int price)   
	{  
	this.price = price;  
	} 
}
