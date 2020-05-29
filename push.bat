git status

git add ./

echo please enter commit note
set /p content=

git commit -m '%content%' && git pull -r origin master && git push origin master


