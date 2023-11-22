package com.example.e2ekernelengine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.e2ekernelengine.crawler.service.RssCrawler;

@Component
public class DataLoader {

	private final RssCrawler rssCrawler;
	private final List<String> blogRssUrlList = new ArrayList<>();

	@Autowired
	public DataLoader(RssCrawler rssCrawler) {
		this.rssCrawler = rssCrawler;

		blogRssUrlList.add("https://medium.com/feed/@dev29cm");
		blogRssUrlList.add("https://ridicorp.com/feed/");
		blogRssUrlList.add("https://blog.dramancompany.com/feed/");
		blogRssUrlList.add("https://techblog.yogiyo.co.kr/feed");
		blogRssUrlList.add("https://blog.hwahae.co.kr/rss.xml");
		blogRssUrlList.add("https://medium.com/feed/wantedjobs");
		blogRssUrlList.add("https://techblog.gccompany.co.kr/feed");
		blogRssUrlList.add("https://startlink.blog/feed/");
		blogRssUrlList.add("https://tech.devsisters.com/rss.xml");
		blogRssUrlList.add("https://medium.com/feed/naver-place-dev");
		blogRssUrlList.add("https://medium.com/feed/watcha");
		blogRssUrlList.add("https://netflixtechblog.com/feed");
		blogRssUrlList.add("https://toss.tech/rss.xml");
		blogRssUrlList.add("https://medium.com/feed/daangn");
		blogRssUrlList.add("https://tech.kakao.com/feed/");
		blogRssUrlList.add("https://techblog.lycorp.co.jp/ko/feed/index.xml");
		blogRssUrlList.add("https://blog.banksalad.com/rss.xml");
		blogRssUrlList.add("https://techblog.woowahan.com/feed/");
		blogRssUrlList.add("https://tech.inflab.com/rss.xml");
		blogRssUrlList.add("https://medium.com/feed/coupang-engineering");
		blogRssUrlList.add("https://tech.devsisters.com/rss.xml");
		blogRssUrlList.add("https://blog.bespinglobal.com/post/category/aws/feed/");
		blogRssUrlList.add("https://aws.amazon.com/ko/blogs/tech/feed/");
		blogRssUrlList.add("https://tech.scatterlab.co.kr/feed");
		blogRssUrlList.add("https://makinarocks.github.io/feed");
		blogRssUrlList.add("https://zuminternet.github.io/feed");
		blogRssUrlList.add("https://medium.com/feed/wantedjobs");

		// blogRssUrlList.add("https://hyperconnect.github.io/feed.xml");  // 링크 못 받아옴 -> entry
		// blogRssUrlList.add("https://engineering-skcc.github.io/feed.xml"); // 피드 url 주소를 링크가 아니라 id 태그로 줌
		// blogRssUrlList.add("https://ebay-korea.tistory.com/rss");
		// blogRssUrlList.add("https://team.postype.com/rss");
		// blogRssUrlList.add("https://yanolja.github.io/feed");
		// blogRssUrlList.add("https://meetup.toast.com/rss");
		// blogRssUrlList.add("https://helloworld.kurly.com/feed.xml");
		// blogRssUrlList.add("http://feeds.feedburner.com/GoogleDevelopersKorea");
		// blogRssUrlList.add("https://medium.com/feed/musinsa-tech");
		// blogRssUrlList.add("https://saramin.github.io/feed");
		// blogRssUrlList.add("https://tech.kakaoenterprise.com/feed");
		// blogRssUrlList.add("https://meetup.toast.com/rss");
		// blogRssUrlList.add("https://dev.gmarket.com/rss");
		// blogRssUrlList.add("https://tech.kakaoenterprise.com/rss");
		// blogRssUrlList.add("https://medium.com/feed/class101");
		// blogRssUrlList.add("https://netmarble.engineering/rss");
		// blogRssUrlList.add("https://blog.est.ai/feed.xml");
	}

	public void loadInitialData() throws InterruptedException {
		for (String rssUrl : blogRssUrlList) {
			rssCrawler.assignRssCrawler(rssUrl);
		}
	}
}
