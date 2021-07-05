package com.intel.devclout.gen2.producer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sainijit
 */
//public class TestMain {
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(System.getProperty("user.dir"));
//
////        File file = new File("src\\main\\resources\\keystore.jks");
////        System.out.println(file.getAbsolutePath());
////        BufferedReader br = new BufferedReader(new FileReader(file));
////
////        String st;
////        while ((st = br.readLine()) != null)
////            System.out.println(st);
//
//         List<String> result = new ArrayList<String>();
//
//         searchDirectory(new File("/Users/mkyong/websites"), "post.php");
//
//        int count = fileSearch.getResult().size();
//        if(count ==0){
//            System.out.println("\nNo result found!");
//        }else{
//            System.out.println("\nFound " + count + " result!\n");
//            for (String matched : fileSearch.getResult()){
//                System.out.println("Found : " + matched);
//            }
//        }
//
//    }
//
//    public static void searchDirectory(File directory, String fileNameToSearch) {
//
//        setFileNameToSearch(fileNameToSearch);
//
//        if (directory.isDirectory()) {
//            search(directory);
//        } else {
//            System.out.println(directory.getAbsoluteFile() + " is not a directory!");
//        }
//
//    }
//
//    private void search(File file) {
//
//        if (file.isDirectory()) {
//            System.out.println("Searching directory ... " + file.getAbsoluteFile());
//
//            //do you have permission to read this directory?
//            if (file.canRead()) {
//                for (File temp : file.listFiles()) {
//                    if (temp.isDirectory()) {
//                        search(temp);
//                    } else {
//                        if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {
//                            result.add(temp.getAbsoluteFile().toString());
//                        }
//
//                    }
//                }
//
//            } else {
//                System.out.println(file.getAbsoluteFile() + "Permission Denied");
//            }
//        }
//
//    }
//    }

