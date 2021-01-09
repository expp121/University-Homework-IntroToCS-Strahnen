#!/bin/bash
echo The current time stamp is: | tee /home/practice/output_script
echo `date + "%I:%M %P and %S seconds"` | tee /home/practice/output_script
echo "You are logged in as user: $USER" | tee /home/practice/output_script
echo "Your Home directory is: $HOME" | tee /home/practice/output_script
echo "You currently use shell: $SHELL" | tee /home/practice/output_script
