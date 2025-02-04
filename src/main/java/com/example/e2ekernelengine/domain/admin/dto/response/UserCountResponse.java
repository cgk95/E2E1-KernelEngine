package com.example.e2ekernelengine.domain.admin.dto.response;

import java.util.List;

import com.example.e2ekernelengine.domain.admin.dto.DateAndTotalUserCountDto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserCountResponse {
	private final List<DateAndTotalUserCountDto> thisWeekTotalUserCountList;
	private final List<DateAndTotalUserCountDto> lastWeekTotalUserCountList;

	@Builder
	public UserCountResponse(List<DateAndTotalUserCountDto> thisWeekTotalUserCountList,
			List<DateAndTotalUserCountDto> lastWeekTotalUserCountList) {
		this.thisWeekTotalUserCountList = thisWeekTotalUserCountList;
		this.lastWeekTotalUserCountList = lastWeekTotalUserCountList;
	}
}
