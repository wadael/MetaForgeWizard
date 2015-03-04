# MetaForgeWizard
This software is a Forge2 addon that will help you generate wizard-style addons.
Unlike commands, Forge wizards have several screens to gather the user input.

Because, however simple it is to write a wizard, I hate to have typos that cause runtime errors. And the more steps the more risk of typo. 

So, here comes this addon that will generate all the classes (one per 'screen'), linked between them.


![guy certainly known in the usa, of meme fame in europe][meme]

## Usage example
**wizard-generator** --commandName do-that-business-thing --stepsNames 

BusinessThingStartWizard,BusinessThingStep1,BusinessThingStep2,BusinessThingStep3,BusinessThingStep4,Bus

inessThingStep5,BusinessThingStep6,BusinessThingStep7 --destinationSourceFolder gen

This command will generate 8 classes responding to the Forge command _do-that-business-thing_, put in the folder _gen_.  
You may have more or less steps (Mr Spock would say two is a minimum else write an @Command).

## Next ?
Refactor the package because org.wadael.changeme is probably not what you want in your source tree. Then have a look at the **TODO** in the code. 
And of course, implement your business thing

# Installation
From the Forge prompt, type 
addon-install-from-git --url https://github.com/wadael/MetaForgeWizard.git 

# Pre-requisite
Having Forge installed. Java 1.7. 
Must be used within a project. 
Preferably an addon project :) 

# Memes
I had fun making a serie of memes like the one above

Find them here 
https://plus.google.com/u/0/photos/+J%C3%A9r%C3%B4meBaton/albums/6121992256368557777

# You can help
Yes you can ! Amongst the options,  there is
* file issues/enhancement requests
* send me lots of cash 
* send compliments via gmail  (wadael@) , use MetaForgeWizard in the object
* Thank me in the README of your addon :)









<h2>Fund me</h2>
Paypal me   wadael at gmail

<div>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input name="cmd" value="_s-xclick" type="hidden">
<input name="encrypted" value="-----BEGIN PKCS7-----

MIIHRwYJKoZIhvcNAQcEoIIHODCCBzQCAQExggEwMIIBLAIBADCBlDCBjjELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAkNBMRYwFAYDVQQH

Ew1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtQYXlQYWwgSW5jLjETMBEGA1UECxQKbGl2ZV9jZXJ0czERMA8GA1UEAxQIbGl2ZV9hcGkx

HDAaBgkqhkiG9w0BCQEWDXJlQHBheXBhbC5jb20CAQAwDQYJKoZIhvcNAQEBBQAEgYCZb7ky

+sEWbxNOAQHcUXPW5gzrjfILMFgmH9bWvfYysgxGiAStk4VxpuS4SkQbk8BLMZRVb6BE7Z4MFQnMderzx91oK2Ryl1y4M8Gcm8ocrHyU

m4WZRElh+gwAwxp5BDw2Vi/XhMUE3Psdl0lcf8l+VlPyut9s

+80MwMM/Qjo0SDELMAkGBSsOAwIaBQAwgcQGCSqGSIb3DQEHATAUBggqhkiG9w0DBwQI3CTl4yzybZGAgaD8xoU1q

+NsTkiZ7/mIGTn7LD46W8DJiv7ji6akUhebvWlr6ZholomqyjiogZr8zc2IrHTG4DifpTPdGukD6x60AeWKLHkNF4JTlK9dAeD5KYkOz

/nTUe4KCj8R4EoUuupKyaQR1+FaVoJcz+2UfLUstcGD1reCQzCwKCA1Myqab3QbL+fZvCDGgFV6xqmKelPgNSdYOM75m5dtd9mcWlb

+oIIDhzCCA4MwggLsoAMCAQICAQAwDQYJKoZIhvcNAQEFBQAwgY4xCzAJBgNVBAYTAlVTMQswCQYDVQQIEwJDQTEWMBQGA1UEBxMNTW9

1bnRhaW4gVmlldzEUMBIGA1UEChMLUGF5UGFsIEluYy4xEzARBgNVBAsUCmxpdmVfY2VydHMxETAPBgNVBAMUCGxpdmVfYXBpMRwwGgY

JKoZIhvcNAQkBFg1yZUBwYXlwYWwuY29tMB4XDTA0MDIxMzEwMTMxNVoXDTM1MDIxMzEwMTMxNVowgY4xCzAJBgNVBAYTAlVTMQswCQY

DVQQIEwJDQTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLUGF5UGFsIEluYy4xEzARBgNVBAsUCmxpdmVfY2VydHMxETA

PBgNVBAMUCGxpdmVfYXBpMRwwGgYJKoZIhvcNAQkBFg1yZUBwYXlwYWwuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBR07

d/ETMS1ycjtkpkvjXZe9k

+6CieLuLsPumsJ7QC1odNz3sJiCbs2wC0nLE0uLGaEtXynIgRqIddYCHx88pb5HTXv4SZeuv0Rqq4+axW9PLAAATU8w04qqjaSXgbGLP

3NmohqM6bV9kZZwZLR/klDaQGo1u9uDb9lr4Yn+rBQIDAQABo4HuMIHrMB0GA1UdDgQWBBSWn3y7xm8XvVk/UtcKG

+wQ1mSUazCBuwYDVR0jBIGzMIGwgBSWn3y7xm8XvVk/UtcKG

+wQ1mSUa6GBlKSBkTCBjjELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAkNBMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtQY

XlQYWwgSW5jLjETMBEGA1UECxQKbGl2ZV9jZXJ0czERMA8GA1UEAxQIbGl2ZV9hcGkxHDAaBgkqhkiG9w0BCQEWDXJlQHBheXBhbC5jb

22CAQAwDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQUFAAOBgQCBXzpWmoBa5e9fo6ujionW1hUhPkOBakTr3YCDjbYfvJEiv/2P

+IobhOGJr85+XHhN0v4gUkEDI8r2/rNk1m0GA8HKddvTjyGw/XqXa

+LSTlDYkqI8OwR8GEYj4efEtcRpRYBxV8KxAW93YDWzFGvruKnnLbDAF6VR5w/cCMn5hzGCAZowggGWAgEBMIGUMIGOMQswCQYDVQQGE

wJVUzELMAkGA1UECBMCQ0ExFjAUBgNVBAcTDU1vdW50YWluIFZpZXcxFDASBgNVBAoTC1BheVBhbCBJbmMuMRMwEQYDVQQLFApsaXZlX

2NlcnRzMREwDwYDVQQDFAhsaXZlX2FwaTEcMBoGCSqGSIb3DQEJARYNcmVAcGF5cGFsLmNvbQIBADAJBgUrDgMCGgUAoF0wGAYJKoZIh

vcNAQkDMQsGCSqGSIb3DQEHATAcBgkqhkiG9w0BCQUxDxcNMTQwMjIzMjExODE4WjAjBgkqhkiG9w0BCQQxFgQUAd4PXwO3sjLCJXZEm

mVXOKLev98wDQYJKoZIhvcNAQEBBQAEgYB

+TQRnLzLSe9wNg4Vo1sEZlnry4RfzjOoxH1leJXeJnbNqwUck8cAKgxDinAyEFpnlMX/QeiFM/FkWn4elDYjnJ1e8UsjXVRKgtR/Wa0T

GyA9Vm85x04cOY+89D7YVEhy6zXIXo3dIjWu9f5lIbPLJI2fssF11ll8lGmiQUdxysA==-----END PKCS7-----
" type="hidden">
<input src="https://www.paypalobjects.com/fr_FR/FR/i/btn/btn_donateCC_LG.gif" name="submit" alt="PayPal 

- la solution de paiement en ligne la plus simple et la plus sécurisée !" border="0" type="image">
<img alt="" src="https://www.paypalobjects.com/fr_FR/i/scr/pixel.gif" border="0" height="1" width="1">
</form>
</div>


[meme]:https://lh5.googleusercontent.com/-3VrBI4E-t_A/VPWvh_-aEyI/AAAAAAAAJfs/s-ziRK5hqz8/w490-h428-no/icyfe.jpg
