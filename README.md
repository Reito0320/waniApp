# Wani App
このアプリケーションはandroid Appです。
Kabaに意地悪してきたWaniさんが檻に逃げ込み、檻がWaniで溢れたので、Tapして檻を壊すGameです。

## Setup
お手元のIDEにgit cloneします。
※IDEは IntelliJを推奨
```shell
cd httpTest
./gradlew bootRun
```
このコマンドでSpring Bootが立ち上がります。

次に**Android Studio**で"cat"フォルダを開いてください。
※Android StudioのSetupがまだの型はこちらのサイトを参考にSetUpしてみてください。
https://developer.android.com/studio?hl=ja

catを開いたら、IDE画面右上の実行マークを押してください。
※android端末はGoogle推奨のものが良いです。

これで全てのSetUpが完了しました。

## API
全userの情報を取得
```kotlin
GET /api/users
```
nameを元にuserの情報を新規作成
```kotlin
POST /api/signOn/{name}
```
nameを元にuserの情報を取得
```kotlin
GET /api/login/{name}
```
idを元にuserのGame情報を更新
```kotlin
Patch /api/user/{id}
```

## 学んだこと
## Front
### Android Studio
直感的にUIを作ることができる点が最も良かった。
IDEがIntelliJと似ているので、kotlinを同環境で開発しているエンジニアには抵抗感なく使えるのも利点の一つ。
基本時に見た目の部分はxmlファイルでの操作。
機能の部分はkotlinでの操作
xmlで書いた要素をkotlinで取得する際の流れはJSでのDOM操作とほとんど同じ。

## Back
### Spring boot
Http通信の雛形を公式HPのUI操作で簡単にIDEに構築できた。
最も便利だと感じたのはアーキテクチャーのrepositoryの設定。
ここにAPIとしてよく使う機能が盛り込んである。
また、自分が新しいAPIを作りたい時も簡単に作成できてしまう。

