var main = {
    init : function(){
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });
        $('#btn-update').on('click', function(){
            _this.update();
        })
        $('#btn-delete').on('click', function(){
            _this.remove();
        })
    },
    save : function(){
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json',
            charset: 'UTF-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록됐습니다.');
            window.location.href = '/';
        }).fail(function(){
            console.log(data)
            alert(JSON.stringify(error));
        });
    },
    update : function(){
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json',
            charset: 'UTF-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 수정됐습니다.');
            window.location.href = '/';
        }).fail(function(){
            alert(JSON.stringify(error));
        });
    },

    remove: function(){
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json',
            charset: 'utf-8'
        }).done(function() {
            alert('글이 삭제됐습니다');
            window.location.href = '/';
        }).fail(function(){
            alert(JSON.stringify(error));
        });
    }
};

main.init();