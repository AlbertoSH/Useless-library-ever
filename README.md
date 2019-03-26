# Useless library ever

[ ![Download](https://api.bintray.com/packages/albertosh/maven/useless-library-ever/images/download.svg) ](https://bintray.com/albertosh/maven/useless-library-ever/_latestVersion)

Useless library anyone ever wrote

## Overview

**Useless library ever** breaks your code. Literally. Your `.java` files will still be there (I'm not as bad)
but forget about using the `.class` compiled. **Any call to any method (even constructors) will throw a `RuntimeException` 
claiming that you're ugly**

---

## Features

* Reduces incredibly the size of the compiled files
* Breaks your code

--- 

## Installation

Just add the dependency into your project. It doesn't event need to be a runtime dependency. With just
compile time dependency your code will be broken

    repositories {
        jcenter()
    }
    
    dependencies{
        compile 'com.github.albertosh:useless-library-ever:1.0.0'
    }

---

## How it works

By invoking ancient powers I can channel all the evil forces into your computer and make it obbey my commands

![](https://media.giphy.com/media/ujUdrdpX7Ok5W/giphy.gif)

(Yes, I love that fucking gif)

**OK, now just be serious, please. How do you do that?**

I just modify the AST of your classes. This is just an example of how dangerous a non reliable library 
can be. If you want an example of how powerfull this technique can be you can check my library [MagicBuilder](https://github.com/AlbertoSH/MagicBuilder)

**Why did you do such a stupid library?**


![](https://media.giphy.com/media/oSwcTWom8isyA/giphy.gif)


---

## License
 
    The MIT C
    
    Copyright (c) 2016 Alberto Sanz
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
    
