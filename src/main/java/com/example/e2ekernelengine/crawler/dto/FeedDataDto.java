package com.example.e2ekernelengine.crawler.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

/**
 * 하나의 포스트 정보를 담을수있는 객체
 */
@Getter
public class FeedDataDto {

	private final String link;
	private final String title;
	private final String description;
	private final Timestamp pubDate;
	private final String content;

	@Builder
	public FeedDataDto(String link, String title, Timestamp pubDate, String description, String content) {
		super();
		this.link = link;
		this.title = title;
		this.pubDate = pubDate;
		this.description = description;
		this.content = content;
	}
}
