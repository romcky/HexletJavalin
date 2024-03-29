@import org.example.hexlet.UserBase

@param UserBase userBase

<html>
    <head>
        <meta charset="UTF-8">
        <title>Пользователи</title>
    </head>
    <body>
        <h1> Список пользователей: </h1>
        @if (userBase.getUsers().isEmpty())
            <p>Список пользователей пуст</p>
        @else
            @for (var user : userBase.getUsers())
                <div>
                    <h3><a href="/users/${user.getId()}">${user.getName()}</a></h3>
                </div>
            @endfor
        @endif
    </body>
</html>