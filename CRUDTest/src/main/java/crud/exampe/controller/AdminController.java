package crud.exampe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crud.exampe.model.entity.AdminEntity;
import crud.exampe.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;

	// 新規登録画面を表示
	@GetMapping("/register")
	public String getRegisterPage() {
		return "admin_register_view.html";
	}

	// 登録内容を保存
	@PostMapping("/register")
	public String register(@RequestParam String adminName, @RequestParam String adminEmail, String password) {
		adminService.insert(adminName, adminEmail, password);
		return "redirect:/register";
	}

	// 一覧を表示
	@GetMapping("/admin/all")
	public String getAdminAll(Model model) {
		List<AdminEntity> adminlist = adminService.selectFindAll();
		model.addAttribute("adminlist", adminlist);
		return "admin_all_view.html";
	}

	// 編集画面へ遷移
	@GetMapping("/edit/{adminId}")
	public String getAdminEditPage(@PathVariable Long adminId, Model model) {
		AdminEntity adminEntity = adminService.selectByAdminId(adminId);
		model.addAttribute("admin", adminEntity);
		return "admin_edit_view.html";
	}

	// 編集内容を更新
	@PostMapping("/update")
	public String updateAdmin(@RequestParam Long adminId, @RequestParam String adminName,
			@RequestParam String adminEmail, @RequestParam String password) {
		adminService.update(adminId, adminName, adminEmail, password);
		return "redirect:/admin/all";
	}

	// 内容を削除
	@PostMapping("/delete")
	public String deleteAdmin(@RequestParam Long adminId) {
		adminService.delete(adminId);
		return "redirect:/admin/all";
	}
}