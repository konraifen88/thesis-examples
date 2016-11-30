# Vagrant Docker Image CNTLM version

Vagrantfile to start a Vagrant box. Inside the box docker will be installed and the following services will be pulled and run:

* [Oracle-12c](https://hub.docker.com/r/sath89/oracle-12c/) of Docker-Hub user sath89
* [Redis](https://hub.docker.com/_/redis/) offical Redis image from Docker-Hub
* [Redis Commander](https://hub.docker.com/r/tenstartups/redis-commander/) of Docker-Hub user tenstartups
* [RabbitMQ](https://hub.docker.com/_/rabbitmq/) offical RabbitMQ image from Docker-Hub

All init scripts for the Oracle DB can be found inside the /init/oracle/ directory.

This is the cntlm version of the repo. If you have your proxy configured with cntlm, then you should use this branch.

## Needed Software

* Oracle VM Virtualbox 5.1.8 - [download](http://download.virtualbox.org/virtualbox/5.1.8/VirtualBox-5.1.8-111374-Win.exe)
* Oracle VM Extension Pack 5.1.8 - [download](http://download.virtualbox.org/virtualbox/5.1.8/Oracle_VM_VirtualBox_Extension_Pack-5.1.8.vbox-extpack)
* Vagrant 1.8.7 - [download](https://releases.hashicorp.com/vagrant/1.8.7/vagrant_1.8.7.msi)

Other versions of Virtualbox and Vagrant may run, too.

## Installation

If you are behind a cooperational proxy you may need their root certificate. 
See [HOWTO](init/certificates/HOWTO.md) for more information.

``` shell
git clone https://github.com/konraifen88/vagrant_docker.git
cd vagrant_docker
git checkout cntlm
vagrant up
```

Vagrant should now download base image and install docker with the containers in it.
The first startup will take a very long time. Do not interrupt the process, you will get the terminal back if everything is downloaded.
When finished downloading, the database will still startup!
A script is attached to Vagrantfile which will check if the Database is fully running. 

Hint:
When this script is running, there will be a check all 5 seconds if DB is sucessfully up. But if there is a problem during setting up, the script will run infinitely, then you can break it with 'ctrl + c'.

## Usage

### Start the Box

``` shell
vagrant up
```

### Stop the Box

``` shell
vagrant halt
```

### Check docker logs

``` shell
# Vagrant have to be running
vagrant ssh
# inside devBox do:
docker ps
docker logs <ID of container, see output docker ps>
```

### Adding new data or change the box
See section 'Known Bugs' when adding data to Oracle DB

``` shell
vagrant up --provision
```
## Connect to devBox
	
To connect to devBox you have to connect to:

    192.168.33.10

The current port mappings can be found below.
	
### Current Port Mappings

| Name            | Funktion                               | Port  |
|-----------------|----------------------------------------|-------|
| Redis           | Hauptport zu Verwendung in Applikation | 6379  |
| Redis-Commander | Datenbank Viewer für Redis             | 8081  |
| RabbitMQ        | Hauptport zu Verwendung in Applikation | 5672  |
| RabbitMQ epmd   | -                                      | 4369  |
| RabbitMQ WebUI  | WebUI zur Überwachung von Rabbit       | 15672 |
| Oracle 12c      | Hauptport zu Verwendung in Applikation | 1521  |
| Oracle Apex/EM  | Apex und Enterprise Management console | 8080  |

## Possible Errors
	
Error:
Not Able to Download/Install the Docker in Vagrant Base-Box.

Possible Fix:
Check if http_proxy and https_proxy are set correctly (both has to be set!)

---------------------------------------

Error:
Download of Docker Images fails with x509-Error

Solution:
Check [HOWTO](init/certificates/HOWTO.md) to download the correct certificates.

----------------------------------------

Error:
When getting following error:
    gpg: error reading key: public key not found
    
Solution:
Download gpg by yourself at [mit.edu](http://pgp.mit.edu/pks/lookup?op=get&options=mr&search=0x58118E89F3A912897C070ADBF76221572C52609D)
and save it to
    <project_dir>/init/gpgkey.asc
	

## Known Bugs

Bug:
When change the files init-files of the database and do a reload or provision up, the changes will not applied.

Reason:
Vagrant don't call docker run for a docker container till it's command did not change or on first setup. 
    "restart: "always""
addition will not have any effect!

Workaround:

1. Destroy the box and restart it (the full download of docker containers have to be done!)
2. Change oracle-args in 'images.yml'. You can add/remove a '/' at '-v /vagrant/init/oracle(/)'. For this case, the command has "changed" and it will re-run the container on provision. 
