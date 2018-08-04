# FriGand - gandi.net dynamic DNS update service for your Fritz!Box
FriGand helps your Fritz!Box updating a gandi.net DNS A record

## What it is
FriGand is a spring boot application written in java using jetty, jax-rs, jackson and feign

## What you need
* A [gandi.net API key](https://doc.gandi.net/en/dns/api)
* A domain using Gandi's LiveDNS nameservers

## What it does
FriGand accepts a DynDNS update GET request from your Fritz!Box. 
The query parameters will be translated into a POST for the Gandi V5 API. 
It updates the @ A record for the given domain with a ttl of 300 seconds (gandi.net minimum).  

## Background
Fritz!Box DynDNS support is able to issue a GET when connecting to the internet. 
No POST, no PUT, no headers. <p>
[gandi.net V5 API](https://doc.gandi.net/en/dns/api) is RESTful and accepts a PUT with headers to update DNS records.

## How to use it
Configure your Fritz!Box DynDNS to use the custom service. <p>
Example URL:<br> 
https://apps.economore.io/frigand/update?username=<username>&domain=<domain>&ipaddr=<ipaddr> <p>

Username has to be set to gandi.net API Key and the domain is yours.

If you use it for personal purposes feel free to use our live instance shown.<br>
We do not log anything or store your credentials - but I do understand if you run frigand yourself.  
