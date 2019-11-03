# MediQR

## Introduction
Most of us believe that medical and health information is a part of personal privacy and should be protected. We have perfect rights over our information and who can receive and view them is strictly restricted by the Federal Law[1]. Unfortunately, whether our health information is secure enough or not has become a problem.  According to the Identity Theft Resource Center (ITRC), 43.1 percent of all consumer data breaches reported in 2013 involved medical records, far more than the number of breaches involving banking and financial information or military or educational records. More surprisingly, while hacking is usually considered as the major cause of these breaches, there is an increasing number of “insider-theft” cases, where the information of a patient is illegally accessed by employees like nurses or other doctors[2].


## What it does
The purpose of our project, MediQR, is to transform the profiles of patients into small-sized, encrypted, and safe QR codes, the hidden information of which can only be accessed by the doctor who wrote the profile and the patient via a unique password. Patients can conveniently send their profiles by bringing, showing, or uploading the QR code to the Internet, without worrying about their privacy being disclosed. 

## Project Architecture
MediQR is implemented as a website, built based on the Java framework SpringMVC. The website can either transform a patient profile into a QR code encrypted by the patient id, or decrypted such a QR code based on the id and password. We use xml for our database and AES algorithm to encrypt and decrypt the medical profile. We use an open-source QR-code API to encode and decode medical profiles.

## What's next for MediQR
In the future, we plan to display the MediQR project onto a server and link it with a domain name. 

## Team Members: 
Ziyi Wang (ziyi.wang1@duke.edu)  
Mingkuan Xu(mingkuan.xu@duke.edu)  

## Reference
[1] Your Rights Under HIPAA. The U.S. Department of Health & Human Services (https://www.hhs.gov/hipaa/for-individuals/guidance-materials-for-consumers/index.html)  
[2] Medical Identity Theft. Working Nurse. (https://www.workingnurse.com/articles/Medical-Identity-Theft)  
[3] HTML Template. W3school.(https://www.w3schools.com/w3css/w3css_templates.asp)`
