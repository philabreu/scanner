package com.scanner.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
public class ScannerController {

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/scanner")
	public void callScanner() {
		try {
			System.out.println("Opening scanner");
			Runtime runTime = Runtime.getRuntime();
			Process process = runTime.exec("wiaacmgr");
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Closing scanner");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/notepad")
	public void callNotepad() {
		try {
			System.out.println("Opening notepad");
			Runtime runTime = Runtime.getRuntime();
			Process process = runTime.exec("notepad");
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Closing notepad");
			process.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
