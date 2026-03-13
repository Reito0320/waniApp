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
nameを元にuserの情報を取得
```kotlin
GET /api/login/{name}
```
nameを元にuserの情報を新規作成
```kotlin
POST /api/signOn/{name}
```
idを元にuserのGame情報を更新
```kotlin
PATCH /api/user/{id}
```
idを元にuserのDateを削除
```kotlin
DELETE /api/user/{id}
```

## 使用技術
### postgrest
スタンダートなDBを使用
### spring boot
アプリケーションの雛形生成から、バックエンド周りの便利機能を提供
### Retrofit
client側のHttp通信の設定ができる

## 参考資料
### 公式資料

Kotlin
https://kotlinlang.org/

Spring boot
https://spring.io/projects/spring-boot

android studio
https://developer.android.com/studio?hl=ja

**Spring bootの基本**
https://qiita.com/tarosa0001/items/93ad51f87fa9af31402a

**Kotlinの基本文法**
https://qiita.com/kiririnyo/items/aee905225902d096f7c0

**Spring bootを使ったアーキテクチャー**
https://qiita.com/shibainuu/items/757c2e418459e4b51dd1

**Retrofitの基本**
https://qiita.com/Omj-8/items/7b0cddbb8ae85138aa65
