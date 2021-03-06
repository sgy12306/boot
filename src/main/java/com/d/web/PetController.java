package com.d.web;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.d.service.PetService;
import com.d.util.Result;
import com.di.kit.JsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "宠物", description = "宠物接口")
@RestController
public class PetController {
	@Autowired
	private PetService petService;

	@ApiOperation(value = "列表", notes = "查询宠物列表")
	@GetMapping(path = "/pet/list")
	public Object list(@ApiParam("页码") @RequestParam(defaultValue = "1") int page, @ApiParam("每页大小") @RequestParam(defaultValue = "5") int size) {
		return Arrays.asList(new Pet(1, "alice"));
	}

	@ApiOperation(value = "编辑", notes = "宠物编辑信息")
	@GetMapping(path = "/pet/edit")
	public Object edit(@ApiParam("宠物id") @RequestParam(defaultValue = "1") int id, HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model model) {
		return petService.get(id);
	}

	@ApiOperation(value = "删除", notes = "宠物删除", response = Result.class)
	@GetMapping(path = "/pet/del")
	public Object del(@ApiParam("宠物id") @RequestParam(defaultValue = "1") int id) {
		return Result.success();
	}

	@ApiOperation(value = "保存", notes = "宠物保存", response = Pet.class)
	@PostMapping(path = "/pet/save")
	public Object save(Pet pet) {
		return Result.success(pet);
	}

	@ApiModel("宠物")
	public static class Pet implements Serializable {
		private static final long serialVersionUID = -5310279155008867167L;
		@ApiModelProperty("宠物id")
		Integer id;
		@ApiModelProperty("宠物名称")
		String name;
		List<Area> areas;

		public Pet() {
		}

		public Pet(Integer id, String name) {
			this.id = id;
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Area> getAreas() {
			return areas;
		}

		public void setAreas(List<Area> areas) {
			this.areas = areas;
		}

		@ApiModel("地区")
		public static class Area {
			@ApiModelProperty("编码")
			private Integer id;
			@ApiModelProperty("名称")
			private String name;

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}

		@Override
		public String toString() {
			return JsonUtil.toJson(this);
		}
	}
}
