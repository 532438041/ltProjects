package com.java.dto;

import com.java.entity.Article;

public class ArticleDto extends Article{
	
    private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
    
