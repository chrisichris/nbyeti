Welcome to the yeti netbeans plugin
===================================

This is a very simple plugin for Netbeans to code-higlight yeti files and find matching braces.

That's not a lot but code-higlighting and matching braces already helps quite a bit and because it is so simple it does not always throw exceptions like 
some other much more ambitioned editors for other languages.

There is on purpose not yeti-project provided, because it is much better if you create a maven project with the yeti-maven-plugin and use that.
See [https://github.com/chrisichris/yeti-maven-plugin](https://github.com/chrisichris/yeti-maven-plugin) 

It is tested and developed on Netbeans 6.8 and it also works on Netbeans 6.9  

The plugin is coded according to this nice tutorial: [http://wiki.netbeans.org/How_to_create_support_for_a_new_language](http://wiki.netbeans.org/How_to_create_support_for_a_new_language) 

## Installation

1. Download the module file `org-nbyeti-6-8-01.nbm` from the downloads section of the github project page
2. In Netbeans open the menu: `Tools / Plugins
3. In the Plugins-Dialog chose the `Downloaded` tab and press the `Add Plugins...` button and open in the file-dialog the `org-nbyeti.nbm` you have downloaded in step 1
5. Now the `NB Yeti` module shows in the left pane. Select it and check the check-box and press `Install` at the bottom
5. Follow the wizard.
6. When the wizard warns you that the module is not signed confirm to install anyway (because it is not signed).

Now all *.yeti files should have a blue icon in the File/Projects Explorer and in the editor there should be a bit codehighlighting. 

## Support

Join the discussion mailing list at:

[http://groups.google.com/group/yeti-lang](http://groups.google.com/group/yeti-lang)
