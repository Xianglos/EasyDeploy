package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonUtils {

    /**
     * 执行 PowerShell 命令
     *
     * @param command 要执行的 PowerShell 命令
     */
    public static synchronized void executePSCommand(String command) {

        // 示例调用
        // String command = "Write-Output 'Hello, PowerShell!'";
        // executePowerShellCommand(command);

        ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-Command", command);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("PowerShell 命令执行完毕，退出码: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}