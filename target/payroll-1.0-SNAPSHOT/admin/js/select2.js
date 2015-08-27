! function() {
    if (window.define) var a = window.define;
    if (window.require) var b = window.require;
    if (window.jQuery && jQuery.fn && jQuery.fn.select2 && jQuery.fn.select2.amd) var a = jQuery.fn.select2.amd.define,
        b = jQuery.fn.select2.amd.require;
    var c, b, a;
    ! function(d) {
        function e(a, b) {
            return u.call(a, b)
        }

        function f(a, b) {
            var c, d, e, f, g, h, i, j, k, l, m, n = b && b.split("/"),
                o = s.map,
                p = o && o["*"] || {};
            if (a && "." === a.charAt(0))
                if (b) {
                    for (n = n.slice(0, n.length - 1), a = a.split("/"), g = a.length - 1, s.nodeIdCompat && w.test(a[g]) && (a[g] = a[g].replace(w, "")), a = n.concat(a), k = 0; k < a.length; k += 1)
                        if (m = a[k], "." === m) a.splice(k, 1), k -= 1;
                        else if (".." === m) {
                        if (1 === k && (".." === a[2] || ".." === a[0])) break;
                        k > 0 && (a.splice(k - 1, 2), k -= 2)
                    }
                    a = a.join("/")
                } else 0 === a.indexOf("./") && (a = a.substring(2));
            if ((n || p) && o) {
                for (c = a.split("/"), k = c.length; k > 0; k -= 1) {
                    if (d = c.slice(0, k).join("/"), n)
                        for (l = n.length; l > 0; l -= 1)
                            if (e = o[n.slice(0, l).join("/")], e && (e = e[d])) {
                                f = e, h = k;
                                break
                            }
                    if (f) break;
                    !i && p && p[d] && (i = p[d], j = k)
                }!f && i && (f = i, h = j), f && (c.splice(0, h, f), a = c.join("/"))
            }
            return a
        }

        function g(a, b) {
            return function() {
                return n.apply(d, v.call(arguments, 0).concat([a, b]))
            }
        }

        function h(a) {
            return function(b) {
                return f(b, a)
            }
        }

        function i(a) {
            return function(b) {
                q[a] = b
            }
        }

        function j(a) {
            if (e(r, a)) {
                var b = r[a];
                delete r[a], t[a] = !0, m.apply(d, b)
            }
            if (!e(q, a) && !e(t, a)) throw new Error("No " + a);
            return q[a]
        }

        function k(a) {
            var b, c = a ? a.indexOf("!") : -1;
            return c > -1 && (b = a.substring(0, c), a = a.substring(c + 1, a.length)), [b, a]
        }

        function l(a) {
            return function() {
                return s && s.config && s.config[a] || {}
            }
        }
        var m, n, o, p, q = {},
            r = {},
            s = {},
            t = {},
            u = Object.prototype.hasOwnProperty,
            v = [].slice,
            w = /\.js$/;
        o = function(a, b) {
            var c, d = k(a),
                e = d[0];
            return a = d[1], e && (e = f(e, b), c = j(e)), e ? a = c && c.normalize ? c.normalize(a, h(b)) : f(a, b) : (a = f(a, b), d = k(a), e = d[0], a = d[1], e && (c = j(e))), {
                f: e ? e + "!" + a : a,
                n: a,
                pr: e,
                p: c
            }
        }, p = {
            require: function(a) {
                return g(a)
            },
            exports: function(a) {
                var b = q[a];
                return "undefined" != typeof b ? b : q[a] = {}
            },
            module: function(a) {
                return {
                    id: a,
                    uri: "",
                    exports: q[a],
                    config: l(a)
                }
            }
        }, m = function(a, b, c, f) {
            var h, k, l, m, n, s, u = [],
                v = typeof c;
            if (f = f || a, "undefined" === v || "function" === v) {
                for (b = !b.length && c.length ? ["require", "exports", "module"] : b, n = 0; n < b.length; n += 1)
                    if (m = o(b[n], f), k = m.f, "require" === k) u[n] = p.require(a);
                    else if ("exports" === k) u[n] = p.exports(a), s = !0;
                else if ("module" === k) h = u[n] = p.module(a);
                else if (e(q, k) || e(r, k) || e(t, k)) u[n] = j(k);
                else {
                    if (!m.p) throw new Error(a + " missing " + k);
                    m.p.load(m.n, g(f, !0), i(k), {}), u[n] = q[k]
                }
                l = c ? c.apply(q[a], u) : void 0, a && (h && h.exports !== d && h.exports !== q[a] ? q[a] = h.exports : l === d && s || (q[a] = l))
            } else a && (q[a] = c)
        }, c = b = n = function(a, b, c, e, f) {
            if ("string" == typeof a) return p[a] ? p[a](b) : j(o(a, b).f);
            if (!a.splice) {
                if (s = a, s.deps && n(s.deps, s.callback), !b) return;
                b.splice ? (a = b, b = c, c = null) : a = d
            }
            return b = b || function() {}, "function" == typeof c && (c = e, e = f), e ? m(d, a, b, c) : setTimeout(function() {
                m(d, a, b, c)
            }, 4), n
        }, n.config = function(a) {
            return n(a)
        }, c._defined = q, a = function(a, b, c) {
            b.splice || (c = b, b = []), e(q, a) || e(r, a) || (r[a] = [a, b, c])
        }, a.amd = {
            jQuery: !0
        }
    }(), a("almond", function() {}), a("jquery", [], function() {
        var a = jQuery || $;
        return null == a && console && console.error && console.error("Select2: An instance of jQuery or a jQuery-compatible library was not found. Make sure that you are including jQuery before Select2 on your web page."), a
    }), a("select2/utils", [], function() {
        function a(a) {
            var b = a.prototype,
                c = [];
            for (var d in b) {
                var e = b[d];
                "function" == typeof e && "constructor" !== d && c.push(d)
            }
            return c
        }
        var b = {};
        b.Extend = function(a, b) {
            function c() {
                this.constructor = a
            }
            var d = {}.hasOwnProperty;
            for (var e in b) d.call(b, e) && (a[e] = b[e]);
            return c.prototype = b.prototype, a.prototype = new c, a.__super__ = b.prototype, a
        }, b.Decorate = function(b, c) {
            function d() {
                var a = Array.prototype.unshift,
                    d = c.prototype.constructor.length,
                    e = b.prototype.constructor;
                d > 0 && (a.call(arguments, b.prototype.constructor), e = c.prototype.constructor), e.apply(this, arguments)
            }

            function e() {
                this.constructor = d
            }
            var f = a(c),
                g = a(b);
            c.displayName = b.displayName, d.prototype = new e;
            for (var h = 0; h < g.length; h++) {
                var i = g[h];
                d.prototype[i] = b.prototype[i]
            }
            for (var j = (function(a) {
                    var b = function() {};
                    a in d.prototype && (b = d.prototype[a]);
                    var e = c.prototype[a];
                    return function() {
                        var a = Array.prototype.unshift;
                        return a.call(arguments, b), e.apply(this, arguments)
                    }
                }), k = 0; k < f.length; k++) {
                var l = f[k];
                d.prototype[l] = j(l)
            }
            return d
        };
        var c = function() {
            this.listeners = {}
        };
        return c.prototype.on = function(a, b) {
            this.listeners = this.listeners || {}, a in this.listeners ? this.listeners[a].push(b) : this.listeners[a] = [b]
        }, c.prototype.trigger = function(a) {
            var b = Array.prototype.slice;
            this.listeners = this.listeners || {}, a in this.listeners && this.invoke(this.listeners[a], b.call(arguments, 1)), "*" in this.listeners && this.invoke(this.listeners["*"], arguments)
        }, c.prototype.invoke = function(a, b) {
            for (var c = 0, d = a.length; d > c; c++) a[c].apply(this, b)
        }, b.Observable = c, b.generateChars = function(a) {
            for (var b = "", c = 0; a > c; c++) {
                var d = Math.floor(36 * Math.random());
                b += d.toString(36)
            }
            return b
        }, b.bind = function(a, b) {
            return function() {
                a.apply(b, arguments)
            }
        }, b._convertData = function(a) {
            for (var b in a) {
                var c = b.split("-"),
                    d = a;
                if (1 !== c.length) {
                    for (var e = 0; e < c.length; e++) {
                        var f = c[e];
                        f = f.substring(0, 1).toLowerCase() + f.substring(1), f in d || (d[f] = {}), e == c.length - 1 && (d[f] = a[b]), d = d[f]
                    }
                    delete a[b]
                }
            }
            return a
        }, b.hasScroll = function(a, b) {
            var c = $(b),
                d = b.style.overflowX,
                e = b.style.overflowY;
            return d !== e || "hidden" !== e && "visible" !== e ? "scroll" === d || "scroll" === e ? !0 : c.innerHeight() < b.scrollHeight || c.innerWidth() < b.scrollWidth : !1
        }, b
    }), a("select2/results", ["jquery", "./utils"], function(a, b) {
        function c(a, b, d) {
            this.$element = a, this.data = d, this.options = b, c.__super__.constructor.call(this)
        }
        return b.Extend(c, b.Observable), c.prototype.render = function() {
            var b = a('<ul class="select2-results__options" role="tree"></ul>');
            return this.options.get("multiple") && b.attr("aria-multiselectable", "true"), this.$results = b, b
        }, c.prototype.clear = function() {
            this.$results.empty()
        }, c.prototype.displayMessage = function(b) {
            this.clear(), this.hideLoading();
            var c = a('<li role="treeitem" class="select2-results__option"></li>'),
                d = this.options.get("translations").get(b.message);
            c.text(d(b.args)), this.$results.append(c)
        }, c.prototype.append = function(a) {
            this.hideLoading();
            var b = [];
            if (null == a.results || 0 === a.results.length) return void(0 === this.$results.children().length && this.trigger("results:message", {
                message: "noResults"
            }));
            a.results = this.sort(a.results);
            for (var c = 0; c < a.results.length; c++) {
                var d = a.results[c],
                    e = this.option(d);
                b.push(e)
            }
            this.$results.append(b)
        }, c.prototype.position = function(a, b) {
            var c = b.find(".select2-results");
            c.append(a)
        }, c.prototype.sort = function(a) {
            var b = this.options.get("sorter");
            return b(a)
        }, c.prototype.setClasses = function() {
            var b = this;
            this.data.current(function(c) {
                var d = a.map(c, function(a) {
                        return a.id.toString()
                    }),
                    e = b.$results.find(".select2-results__option[aria-selected]");
                e.each(function() {
                    var b = a(this),
                        c = a.data(this, "data");
                    null != c.id && d.indexOf(c.id.toString()) > -1 ? b.attr("aria-selected", "true") : b.attr("aria-selected", "false")
                });
                var f = e.filter("[aria-selected=true]");
                f.length > 0 ? f.first().trigger("mouseenter") : e.first().trigger("mouseenter")
            })
        }, c.prototype.showLoading = function(a) {
            this.hideLoading();
            var b = this.options.get("translations").get("searching"),
                c = {
                    disabled: !0,
                    loading: !0,
                    text: b(a)
                },
                d = this.option(c);
            d.className += " loading-results", this.$results.prepend(d)
        }, c.prototype.hideLoading = function() {
            this.$results.find(".loading-results").remove()
        }, c.prototype.option = function(b) {
            var c = document.createElement("li");
            c.className = "select2-results__option";
            var d = {
                role: "treeitem",
                "aria-selected": "false"
            };
            b.disabled && (delete d["aria-selected"], d["aria-disabled"] = "true"), null == b.id && delete d["aria-selected"], null != b._resultId && (c.id = b._resultId), b.children && (d.role = "group", d["aria-label"] = b.text, delete d["aria-selected"]);
            for (var e in d) {
                var f = d[e];
                c.setAttribute(e, f)
            }
            if (b.children) {
                var g = a(c),
                    h = document.createElement("strong");
                h.className = "select2-results__group"; {
                    a(h)
                }
                this.template(b, h);
                for (var i = [], j = 0; j < b.children.length; j++) {
                    var k = b.children[j],
                        l = this.option(k);
                    i.push(l)
                }
                var m = a("<ul></ul>", {
                    "class": "select2-results__options select2-results__options--nested"
                });
                m.append(i), g.append(h), g.append(m)
            } else this.template(b, c);
            return a.data(c, "data", b), c
        }, c.prototype.bind = function(b) {
            var c = this,
                d = b.id + "-results";
            this.$results.attr("id", d), b.on("results:all", function(a) {
                c.clear(), c.append(a.data), b.isOpen() && c.setClasses()
            }), b.on("results:append", function(a) {
                c.append(a.data), b.isOpen() && c.setClasses()
            }), b.on("query", function(a) {
                c.showLoading(a)
            }), b.on("select", function() {
                b.isOpen() && c.setClasses()
            }), b.on("unselect", function() {
                b.isOpen() && c.setClasses()
            }), b.on("open", function() {
                c.$results.attr("aria-expanded", "true"), c.$results.attr("aria-hidden", "false"), c.setClasses(), c.ensureHighlightVisible()
            }), b.on("close", function() {
                c.$results.attr("aria-expanded", "false"), c.$results.attr("aria-hidden", "true"), c.$results.removeAttr("aria-activedescendant")
            }), b.on("results:select", function() {
                var a = c.getHighlightedResults();
                if (0 !== a.length) {
                    var b = a.data("data");
                    "true" == a.attr("aria-selected") ? c.options.get("multiple") ? c.trigger("unselect", {
                        data: b
                    }) : c.trigger("close") : c.trigger("select", {
                        data: b
                    })
                }
            }), b.on("results:previous", function() {
                var a = c.getHighlightedResults(),
                    b = c.$results.find("[aria-selected]"),
                    d = b.index(a);
                if (0 !== d) {
                    var e = d - 1;
                    0 === a.length && (e = 0);
                    var f = b.eq(e);
                    f.trigger("mouseenter");
                    var g = c.$results.offset().top,
                        h = f.offset().top,
                        i = c.$results.scrollTop() + (h - g);
                    0 === e ? c.$results.scrollTop(0) : 0 > h - g && c.$results.scrollTop(i)
                }
            }), b.on("results:next", function() {
                var a = c.getHighlightedResults(),
                    b = c.$results.find("[aria-selected]"),
                    d = b.index(a),
                    e = d + 1;
                if (!(e >= b.length)) {
                    var f = b.eq(e);
                    f.trigger("mouseenter");
                    var g = c.$results.offset().top + c.$results.outerHeight(!1),
                        h = f.offset().top + f.outerHeight(!1),
                        i = c.$results.scrollTop() + h - g;
                    0 === e ? c.$results.scrollTop(0) : h > g && c.$results.scrollTop(i)
                }
            }), b.on("results:focus", function(a) {
                a.element.addClass("select2-results__option--highlighted")
            }), b.on("results:message", function(a) {
                c.displayMessage(a)
            }), a.fn.mousewheel && this.$results.on("mousewheel", function(a) {
                var b = c.$results.scrollTop(),
                    d = c.$results.get(0).scrollHeight - c.$results.scrollTop() + a.deltaY,
                    e = a.deltaY > 0 && b - a.deltaY <= 0,
                    f = a.deltaY < 0 && d <= c.$results.height();
                e ? (c.$results.scrollTop(0), a.preventDefault(), a.stopPropagation()) : f && (c.$results.scrollTop(c.$results.get(0).scrollHeight - c.$results.height()), a.preventDefault(), a.stopPropagation())
            }), this.$results.on("mouseup", ".select2-results__option[aria-selected]", function(b) {
                var d = a(this),
                    e = d.data("data");
                return "true" === d.attr("aria-selected") ? void(c.options.get("multiple") ? c.trigger("unselect", {
                    originalEvent: b,
                    data: e
                }) : c.trigger("close")) : void c.trigger("select", {
                    originalEvent: b,
                    data: e
                })
            }), this.$results.on("mouseenter", ".select2-results__option[aria-selected]", function() {
                var b = a(this).data("data");
                c.getHighlightedResults().removeClass("select2-results__option--highlighted"), c.trigger("results:focus", {
                    data: b,
                    element: a(this)
                })
            })
        }, c.prototype.getHighlightedResults = function() {
            var a = this.$results.find(".select2-results__option--highlighted");
            return a
        }, c.prototype.destroy = function() {
            this.$results.remove()
        }, c.prototype.ensureHighlightVisible = function() {
            var a = this.getHighlightedResults();
            if (0 !== a.length) {
                var b = this.$results.find("[aria-selected]"),
                    c = b.index(a),
                    d = this.$results.offset().top,
                    e = a.offset().top,
                    f = this.$results.scrollTop() + (e - d),
                    g = e - d;
                f -= 2 * a.outerHeight(!1), 2 >= c ? this.$results.scrollTop(0) : (g > this.$results.outerHeight() || 0 > g) && this.$results.scrollTop(f)
            }
        }, c.prototype.template = function(a, b) {
            var c = this.options.get("templateResult"),
                d = c(a);
            null == d ? b.style.display = "none" : b.innerHTML = d
        }, c
    }), a("select2/keys", [], function() {
        var a = {
            BACKSPACE: 8,
            TAB: 9,
            ENTER: 13,
            SHIFT: 16,
            CTRL: 17,
            ALT: 18,
            ESC: 27,
            SPACE: 32,
            PAGE_UP: 33,
            PAGE_DOWN: 34,
            END: 35,
            HOME: 36,
            LEFT: 37,
            UP: 38,
            RIGHT: 39,
            DOWN: 40,
            DELETE: 46,
            isArrow: function(a) {
                switch (a = a.which ? a.which : a) {
                    case KEY.LEFT:
                    case KEY.RIGHT:
                    case KEY.UP:
                    case KEY.DOWN:
                        return !0
                }
                return !1
            }
        };
        return a
    }), a("select2/selection/base", ["jquery", "../utils", "../keys"], function(a, b, c) {
        function d(a, b) {
            this.$element = a, this.options = b, d.__super__.constructor.call(this)
        }
        return b.Extend(d, b.Observable), d.prototype.render = function() {
            var b = a('<span class="select2-selection" tabindex="0" role="combobox" aria-autocomplete="list" aria-haspopup="true" aria-expanded="false"></span>');
            return b.attr("title", this.$element.attr("title")), this.$selection = b, b
        }, d.prototype.bind = function(a) {
            var b = this,
                d = (a.id + "-container", a.id + "-results");
            this.container = a, this.$selection.attr("aria-owns", d), this.$selection.on("keydown", function(a) {
                b.trigger("keypress", a), a.which === c.SPACE && a.preventDefault()
            }), a.on("results:focus", function(a) {
                b.$selection.attr("aria-activedescendant", a.data._resultId)
            }), a.on("selection:update", function(a) {
                b.update(a.data)
            }), a.on("open", function() {
                b.$selection.attr("aria-expanded", "true"), b._attachCloseHandler(a)
            }), a.on("close", function() {
                b.$selection.attr("aria-expanded", "false"), b.$selection.removeAttr("aria-activedescendant"), b.$selection.focus(), b._detachCloseHandler(a)
            }), a.on("enable", function() {
                b.$selection.attr("tabindex", "0")
            }), a.on("disable", function() {
                b.$selection.attr("tabindex", "-1")
            })
        }, d.prototype._attachCloseHandler = function(b) {
            a(document.body).on("mousedown.select2." + b.id, function(b) {
                var c = a(b.target),
                    d = c.closest(".select2"),
                    e = a(".select2.select2-container--open");
                e.each(function() {
                    var b = a(this);
                    if (this != d[0]) {
                        var c = b.data("element");
                        c.select2("close")
                    }
                })
            })
        }, d.prototype._detachCloseHandler = function(b) {
            a(document.body).off("mousedown.select2." + b.id)
        }, d.prototype.position = function(a, b) {
            var c = b.find(".selection");
            c.append(a)
        }, d.prototype.destroy = function() {
            this._detachCloseHandler(this.container)
        }, d.prototype.update = function() {
            throw new Error("The `update` method must be defined in child classes.")
        }, d
    }), a("select2/selection/single", ["jquery", "./base", "../utils", "../keys"], function(a, b, c) {
        function d() {
            d.__super__.constructor.apply(this, arguments)
        }
        return c.Extend(d, b), d.prototype.render = function() {
            var a = d.__super__.render.call(this);
            return a.addClass("select2-selection--single"), a.html('<span class="select2-selection__rendered"></span><span class="select2-selection__arrow" role="presentation"><b role="presentation"></b></span>'), a
        }, d.prototype.bind = function(a) {
            var b = this;
            d.__super__.bind.apply(this, arguments);
            var c = a.id + "-container";
            this.$selection.find(".select2-selection__rendered").attr("id", c), this.$selection.attr("aria-labelledby", c), this.$selection.on("mousedown", function(a) {
                1 === a.which && b.trigger("toggle", {
                    originalEvent: a
                })
            }), this.$selection.on("focus", function() {}), this.$selection.on("blur", function() {}), a.on("selection:update", function(a) {
                b.update(a.data)
            })
        }, d.prototype.clear = function() {
            this.$selection.find(".select2-selection__rendered").empty()
        }, d.prototype.display = function(a) {
            var b = this.options.get("templateSelection");
            return b(a)
        }, d.prototype.selectionContainer = function() {
            return a("<span></span>")
        }, d.prototype.update = function(a) {
            if (0 === a.length) return void this.clear();
            var b = a[0],
                c = this.display(b);
            this.$selection.find(".select2-selection__rendered").html(c)
        }, d
    }), a("select2/selection/multiple", ["jquery", "./base", "../utils"], function(a, b, c) {
        function d() {
            d.__super__.constructor.apply(this, arguments)
        }
        return c.Extend(d, b), d.prototype.render = function() {
            var a = d.__super__.render.call(this);
            return a.addClass("select2-selection--multiple"), a.html('<ul class="select2-selection__rendered"></ul>'), a
        }, d.prototype.bind = function() {
            var b = this;
            d.__super__.bind.apply(this, arguments), this.$selection.on("click", function(a) {
                b.trigger("toggle", {
                    originalEvent: a
                })
            }), this.$selection.on("click", ".select2-selection__choice__remove", function(c) {
                var d = a(this),
                    e = d.parent(),
                    f = e.data("data");
                b.trigger("unselect", {
                    originalEvent: c,
                    data: f
                })
            })
        }, d.prototype.clear = function() {
            this.$selection.find(".select2-selection__rendered").empty()
        }, d.prototype.display = function(a) {
            var b = this.options.get("templateSelection");
            return b(a)
        }, d.prototype.selectionContainer = function() {
            var b = a('<li class="select2-selection__choice"><span class="select2-selection__choice__remove" role="presentation">&times;</span></li>');
            return b
        }, d.prototype.update = function(a) {
            if (this.clear(), 0 !== a.length) {
                for (var b = [], c = 0; c < a.length; c++) {
                    var d = a[c],
                        e = this.display(d),
                        f = this.selectionContainer();
                    f.append(e), f.data("data", d), b.push(f)
                }
                this.$selection.find(".select2-selection__rendered").append(b)
            }
        }, d
    }), a("select2/selection/placeholder", ["../utils"], function() {
        function a(a, b, c) {
            this.placeholder = this.normalizePlaceholder(c.get("placeholder")), a.call(this, b, c)
        }
        return a.prototype.normalizePlaceholder = function(a, b) {
            return "string" == typeof b && (b = {
                id: "",
                text: b
            }), b
        }, a.prototype.createPlaceholder = function(a, b) {
            var c = this.selectionContainer();
            return c.html(this.display(b)), c.addClass("select2-selection__placeholder").removeClass("select2-selection__choice"), c
        }, a.prototype.update = function(a, b) {
            var c = 1 == b.length && b[0].id != this.placeholder.id,
                d = b.length > 1;
            if (d || c) return a.call(this, b);
            this.clear();
            var e = this.createPlaceholder(this.placeholder);
            this.$selection.find(".select2-selection__rendered").append(e)
        }, a
    }), a("select2/selection/allowClear", ["jquery"], function(a) {
        function b() {}
        return b.prototype.bind = function(b, c, d) {
            var e = this;
            b.call(this, c, d), this.$selection.on("mousedown", ".select2-selection__clear", function(b) {
                if (!e.options.get("disabled")) {
                    b.stopPropagation();
                    for (var c = a(this).data("data"), d = 0; d < c.length; d++) {
                        var f = {
                            data: c[d]
                        };
                        if (e.trigger("unselect", f), f.prevented) return
                    }
                    e.$element.val(e.placeholder.id).trigger("change"), e.trigger("toggle")
                }
            })
        }, b.prototype.update = function(b, c) {
            if (b.call(this, c), !(this.$selection.find(".select2-selection__placeholder").length > 0 || 0 === c.length)) {
                var d = a('<span class="select2-selection__clear">&times;</span>');
                d.data("data", c), this.$selection.find(".select2-selection__rendered").append(d)
            }
        }, b
    }), a("select2/selection/search", ["jquery", "../utils", "../keys"], function(a, b, c) {
        function d(a, b, c) {
            a.call(this, b, c)
        }
        return d.prototype.render = function(b) {
            var c = a('<li class="select2-search select2-search--inline"><input class="select2-search__field" type="search" tabindex="-1" role="textbox" /></li>');
            this.$searchContainer = c, this.$search = c.find("input");
            var d = b.call(this);
            return d
        }, d.prototype.bind = function(a, b, d) {
            var e = this;
            a.call(this, b, d), b.on("open", function() {
                e.$search.attr("tabindex", 0), e.$search.focus()
            }), b.on("close", function() {
                e.$search.attr("tabindex", -1), e.$search.val("")
            }), b.on("enable", function() {
                e.$search.prop("disabled", !1)
            }), b.on("disable", function() {
                e.$search.prop("disabled", !0)
            }), this.$selection.on("keydown", ".select2-search--inline", function(a) {
                a.stopPropagation(), e.trigger("keypress", a), e._keyUpPrevented = a.isDefaultPrevented();
                var b = a.which;
                if (b === c.BACKSPACE && "" === e.$search.val()) {
                    var d = e.$searchContainer.prev(".select2-selection__choice");
                    if (d.length > 0) {
                        var f = d.data("data");
                        e.searchRemoveChoice(f)
                    }
                }
            }), this.$selection.on("keyup", ".select2-search--inline", function(a) {
                e.handleSearch(a)
            })
        }, d.prototype.createPlaceholder = function(a, b) {
            this.$search.attr("placeholder", b.text)
        }, d.prototype.update = function(a, b) {
            this.$search.attr("placeholder", ""), a.call(this, b), this.$selection.find(".select2-selection__rendered").append(this.$searchContainer), this.resizeSearch()
        }, d.prototype.handleSearch = function() {
            if (this.resizeSearch(), !this._keyUpPrevented) {
                var a = this.$search.val();
                this.trigger("query", {
                    term: a
                })
            }
            this._keyUpPrevented = !1
        }, d.prototype.searchRemoveChoice = function(a, b) {
            this.trigger("unselect", {
                data: b
            }), this.trigger("open"), this.$search.val(b.text + " ")
        }, d.prototype.resizeSearch = function() {
            this.$search.css("width", "25px");
            var a = "";
            if ("" !== this.$search.attr("placeholder")) a = this.$selection.find(".select2-selection__rendered").innerWidth();
            else {
                var b = this.$search.val().length + 1;
                a = .75 * b + "em"
            }
            this.$search.css("width", a)
        }, d
    }), a("select2/selection/eventRelay", ["jquery"], function(a) {
        function b() {}
        return b.prototype.bind = function(b, c, d) {
            var e = this,
                f = ["open", "opening", "close", "closing", "select", "selecting", "unselect", "unselecting"],
                g = ["opening", "closing", "selecting", "unselecting"];
            b.call(this, c, d), c.on("*", function(b, c) {
                if (-1 !== f.indexOf(b)) {
                    c = c || {};
                    var d = a.Event("select2:" + b, {
                        params: c
                    });
                    e.$element.trigger(d), -1 !== g.indexOf(b) && (c.prevented = d.isDefaultPrevented())
                }
            })
        }, b
    }), a("select2/translation", ["jquery"], function(a) {
        function c(a) {
            this.dict = a || {}
        }
        return c.prototype.all = function() {
            return this.dict
        }, c.prototype.get = function(a) {
            return this.dict[a]
        }, c.prototype.extend = function(b) {
            this.dict = a.extend({}, b.all(), this.dict)
        }, c._cache = {}, c.loadPath = function(a) {
            if (!(a in c._cache)) {
                var d = b(a);
                c._cache[a] = d
            }
            return new c(c._cache[a])
        }, c
    }), a("select2/diacritics", [], function() {
        var a = {
            "â’¶": "A",
            "ï¼¡": "A",
            "Ã€": "A",
            "Ã": "A",
            "Ã‚": "A",
            "áº¦": "A",
            "áº¤": "A",
            "áºª": "A",
            "áº¨": "A",
            "Ãƒ": "A",
            "Ä€": "A",
            "Ä‚": "A",
            "áº°": "A",
            "áº®": "A",
            "áº´": "A",
            "áº²": "A",
            "È¦": "A",
            "Ç ": "A",
            "Ã„": "A",
            "Çž": "A",
            "áº¢": "A",
            "Ã…": "A",
            "Çº": "A",
            "Ç": "A",
            "È€": "A",
            "È‚": "A",
            "áº ": "A",
            "áº¬": "A",
            "áº¶": "A",
            "á¸€": "A",
            "Ä„": "A",
            "Èº": "A",
            "â±¯": "A",
            "êœ²": "AA",
            "Ã†": "AE",
            "Ç¼": "AE",
            "Ç¢": "AE",
            "êœ´": "AO",
            "êœ¶": "AU",
            "êœ¸": "AV",
            "êœº": "AV",
            "êœ¼": "AY",
            "â’·": "B",
            "ï¼¢": "B",
            "á¸‚": "B",
            "á¸„": "B",
            "á¸†": "B",
            "Éƒ": "B",
            "Æ‚": "B",
            "Æ": "B",
            "â’¸": "C",
            "ï¼£": "C",
            "Ä†": "C",
            "Äˆ": "C",
            "ÄŠ": "C",
            "ÄŒ": "C",
            "Ã‡": "C",
            "á¸ˆ": "C",
            "Æ‡": "C",
            "È»": "C",
            "êœ¾": "C",
            "â’¹": "D",
            "ï¼¤": "D",
            "á¸Š": "D",
            "ÄŽ": "D",
            "á¸Œ": "D",
            "á¸": "D",
            "á¸’": "D",
            "á¸Ž": "D",
            "Ä": "D",
            "Æ‹": "D",
            "ÆŠ": "D",
            "Æ‰": "D",
            "ê¹": "D",
            "Ç±": "DZ",
            "Ç„": "DZ",
            "Ç²": "Dz",
            "Ç…": "Dz",
            "â’º": "E",
            "ï¼¥": "E",
            "Ãˆ": "E",
            "Ã‰": "E",
            "ÃŠ": "E",
            "á»€": "E",
            "áº¾": "E",
            "á»„": "E",
            "á»‚": "E",
            "áº¼": "E",
            "Ä’": "E",
            "á¸”": "E",
            "á¸–": "E",
            "Ä”": "E",
            "Ä–": "E",
            "Ã‹": "E",
            "áºº": "E",
            "Äš": "E",
            "È„": "E",
            "È†": "E",
            "áº¸": "E",
            "á»†": "E",
            "È¨": "E",
            "á¸œ": "E",
            "Ä˜": "E",
            "á¸˜": "E",
            "á¸š": "E",
            "Æ": "E",
            "ÆŽ": "E",
            "â’»": "F",
            "ï¼¦": "F",
            "á¸ž": "F",
            "Æ‘": "F",
            "ê»": "F",
            "â’¼": "G",
            "ï¼§": "G",
            "Ç´": "G",
            "Äœ": "G",
            "á¸ ": "G",
            "Äž": "G",
            "Ä ": "G",
            "Ç¦": "G",
            "Ä¢": "G",
            "Ç¤": "G",
            "Æ“": "G",
            "êž ": "G",
            "ê½": "G",
            "ê¾": "G",
            "â’½": "H",
            "ï¼¨": "H",
            "Ä¤": "H",
            "á¸¢": "H",
            "á¸¦": "H",
            "Èž": "H",
            "á¸¤": "H",
            "á¸¨": "H",
            "á¸ª": "H",
            "Ä¦": "H",
            "â±§": "H",
            "â±µ": "H",
            "êž": "H",
            "â’¾": "I",
            "ï¼©": "I",
            "ÃŒ": "I",
            "Ã": "I",
            "ÃŽ": "I",
            "Ä¨": "I",
            "Äª": "I",
            "Ä¬": "I",
            "Ä°": "I",
            "Ã": "I",
            "á¸®": "I",
            "á»ˆ": "I",
            "Ç": "I",
            "Èˆ": "I",
            "ÈŠ": "I",
            "á»Š": "I",
            "Ä®": "I",
            "á¸¬": "I",
            "Æ—": "I",
            "â’¿": "J",
            "ï¼ª": "J",
            "Ä´": "J",
            "Éˆ": "J",
            "â“€": "K",
            "ï¼«": "K",
            "á¸°": "K",
            "Ç¨": "K",
            "á¸²": "K",
            "Ä¶": "K",
            "á¸´": "K",
            "Æ˜": "K",
            "â±©": "K",
            "ê€": "K",
            "ê‚": "K",
            "ê„": "K",
            "êž¢": "K",
            "â“": "L",
            "ï¼¬": "L",
            "Ä¿": "L",
            "Ä¹": "L",
            "Ä½": "L",
            "á¸¶": "L",
            "á¸¸": "L",
            "Ä»": "L",
            "á¸¼": "L",
            "á¸º": "L",
            "Å": "L",
            "È½": "L",
            "â±¢": "L",
            "â± ": "L",
            "êˆ": "L",
            "ê†": "L",
            "êž€": "L",
            "Ç‡": "LJ",
            "Çˆ": "Lj",
            "â“‚": "M",
            "ï¼­": "M",
            "á¸¾": "M",
            "á¹€": "M",
            "á¹‚": "M",
            "â±®": "M",
            "Æœ": "M",
            "â“ƒ": "N",
            "ï¼®": "N",
            "Ç¸": "N",
            "Åƒ": "N",
            "Ã‘": "N",
            "á¹„": "N",
            "Å‡": "N",
            "á¹†": "N",
            "Å…": "N",
            "á¹Š": "N",
            "á¹ˆ": "N",
            "È ": "N",
            "Æ": "N",
            "êž": "N",
            "êž¤": "N",
            "ÇŠ": "NJ",
            "Ç‹": "Nj",
            "â“„": "O",
            "ï¼¯": "O",
            "Ã’": "O",
            "Ã“": "O",
            "Ã”": "O",
            "á»’": "O",
            "á»": "O",
            "á»–": "O",
            "á»”": "O",
            "Ã•": "O",
            "á¹Œ": "O",
            "È¬": "O",
            "á¹Ž": "O",
            "ÅŒ": "O",
            "á¹": "O",
            "á¹’": "O",
            "ÅŽ": "O",
            "È®": "O",
            "È°": "O",
            "Ã–": "O",
            "Èª": "O",
            "á»Ž": "O",
            "Å": "O",
            "Ç‘": "O",
            "ÈŒ": "O",
            "ÈŽ": "O",
            "Æ ": "O",
            "á»œ": "O",
            "á»š": "O",
            "á» ": "O",
            "á»ž": "O",
            "á»¢": "O",
            "á»Œ": "O",
            "á»˜": "O",
            "Çª": "O",
            "Ç¬": "O",
            "Ã˜": "O",
            "Ç¾": "O",
            "Æ†": "O",
            "ÆŸ": "O",
            "êŠ": "O",
            "êŒ": "O",
            "Æ¢": "OI",
            "êŽ": "OO",
            "È¢": "OU",
            "â“…": "P",
            "ï¼°": "P",
            "á¹”": "P",
            "á¹–": "P",
            "Æ¤": "P",
            "â±£": "P",
            "ê": "P",
            "ê’": "P",
            "ê”": "P",
            "â“†": "Q",
            "ï¼±": "Q",
            "ê–": "Q",
            "ê˜": "Q",
            "ÉŠ": "Q",
            "â“‡": "R",
            "ï¼²": "R",
            "Å”": "R",
            "á¹˜": "R",
            "Å˜": "R",
            "È": "R",
            "È’": "R",
            "á¹š": "R",
            "á¹œ": "R",
            "Å–": "R",
            "á¹ž": "R",
            "ÉŒ": "R",
            "â±¤": "R",
            "êš": "R",
            "êž¦": "R",
            "êž‚": "R",
            "â“ˆ": "S",
            "ï¼³": "S",
            "áºž": "S",
            "Åš": "S",
            "á¹¤": "S",
            "Åœ": "S",
            "á¹ ": "S",
            "Å ": "S",
            "á¹¦": "S",
            "á¹¢": "S",
            "á¹¨": "S",
            "È˜": "S",
            "Åž": "S",
            "â±¾": "S",
            "êž¨": "S",
            "êž„": "S",
            "â“‰": "T",
            "ï¼´": "T",
            "á¹ª": "T",
            "Å¤": "T",
            "á¹¬": "T",
            "Èš": "T",
            "Å¢": "T",
            "á¹°": "T",
            "á¹®": "T",
            "Å¦": "T",
            "Æ¬": "T",
            "Æ®": "T",
            "È¾": "T",
            "êž†": "T",
            "êœ¨": "TZ",
            "â“Š": "U",
            "ï¼µ": "U",
            "Ã™": "U",
            "Ãš": "U",
            "Ã›": "U",
            "Å¨": "U",
            "á¹¸": "U",
            "Åª": "U",
            "á¹º": "U",
            "Å¬": "U",
            "Ãœ": "U",
            "Ç›": "U",
            "Ç—": "U",
            "Ç•": "U",
            "Ç™": "U",
            "á»¦": "U",
            "Å®": "U",
            "Å°": "U",
            "Ç“": "U",
            "È”": "U",
            "È–": "U",
            "Æ¯": "U",
            "á»ª": "U",
            "á»¨": "U",
            "á»®": "U",
            "á»¬": "U",
            "á»°": "U",
            "á»¤": "U",
            "á¹²": "U",
            "Å²": "U",
            "á¹¶": "U",
            "á¹´": "U",
            "É„": "U",
            "â“‹": "V",
            "ï¼¶": "V",
            "á¹¼": "V",
            "á¹¾": "V",
            "Æ²": "V",
            "êž": "V",
            "É…": "V",
            "ê ": "VY",
            "â“Œ": "W",
            "ï¼·": "W",
            "áº€": "W",
            "áº‚": "W",
            "Å´": "W",
            "áº†": "W",
            "áº„": "W",
            "áºˆ": "W",
            "â±²": "W",
            "â“": "X",
            "ï¼¸": "X",
            "áºŠ": "X",
            "áºŒ": "X",
            "â“Ž": "Y",
            "ï¼¹": "Y",
            "á»²": "Y",
            "Ã": "Y",
            "Å¶": "Y",
            "á»¸": "Y",
            "È²": "Y",
            "áºŽ": "Y",
            "Å¸": "Y",
            "á»¶": "Y",
            "á»´": "Y",
            "Æ³": "Y",
            "ÉŽ": "Y",
            "á»¾": "Y",
            "â“": "Z",
            "ï¼º": "Z",
            "Å¹": "Z",
            "áº": "Z",
            "Å»": "Z",
            "Å½": "Z",
            "áº’": "Z",
            "áº”": "Z",
            "Æµ": "Z",
            "È¤": "Z",
            "â±¿": "Z",
            "â±«": "Z",
            "ê¢": "Z",
            "â“": "a",
            "ï½": "a",
            "áºš": "a",
            "Ã ": "a",
            "Ã¡": "a",
            "Ã¢": "a",
            "áº§": "a",
            "áº¥": "a",
            "áº«": "a",
            "áº©": "a",
            "Ã£": "a",
            "Ä": "a",
            "Äƒ": "a",
            "áº±": "a",
            "áº¯": "a",
            "áºµ": "a",
            "áº³": "a",
            "È§": "a",
            "Ç¡": "a",
            "Ã¤": "a",
            "ÇŸ": "a",
            "áº£": "a",
            "Ã¥": "a",
            "Ç»": "a",
            "ÇŽ": "a",
            "È": "a",
            "Èƒ": "a",
            "áº¡": "a",
            "áº­": "a",
            "áº·": "a",
            "á¸": "a",
            "Ä…": "a",
            "â±¥": "a",
            "É": "a",
            "êœ³": "aa",
            "Ã¦": "ae",
            "Ç½": "ae",
            "Ç£": "ae",
            "êœµ": "ao",
            "êœ·": "au",
            "êœ¹": "av",
            "êœ»": "av",
            "êœ½": "ay",
            "â“‘": "b",
            "ï½‚": "b",
            "á¸ƒ": "b",
            "á¸…": "b",
            "á¸‡": "b",
            "Æ€": "b",
            "Æƒ": "b",
            "É“": "b",
            "â“’": "c",
            "ï½ƒ": "c",
            "Ä‡": "c",
            "Ä‰": "c",
            "Ä‹": "c",
            "Ä": "c",
            "Ã§": "c",
            "á¸‰": "c",
            "Æˆ": "c",
            "È¼": "c",
            "êœ¿": "c",
            "â†„": "c",
            "â““": "d",
            "ï½„": "d",
            "á¸‹": "d",
            "Ä": "d",
            "á¸": "d",
            "á¸‘": "d",
            "á¸“": "d",
            "á¸": "d",
            "Ä‘": "d",
            "ÆŒ": "d",
            "É–": "d",
            "É—": "d",
            "êº": "d",
            "Ç³": "dz",
            "Ç†": "dz",
            "â“”": "e",
            "ï½…": "e",
            "Ã¨": "e",
            "Ã©": "e",
            "Ãª": "e",
            "á»": "e",
            "áº¿": "e",
            "á»…": "e",
            "á»ƒ": "e",
            "áº½": "e",
            "Ä“": "e",
            "á¸•": "e",
            "á¸—": "e",
            "Ä•": "e",
            "Ä—": "e",
            "Ã«": "e",
            "áº»": "e",
            "Ä›": "e",
            "È…": "e",
            "È‡": "e",
            "áº¹": "e",
            "á»‡": "e",
            "È©": "e",
            "á¸": "e",
            "Ä™": "e",
            "á¸™": "e",
            "á¸›": "e",
            "É‡": "e",
            "É›": "e",
            "Ç": "e",
            "â“•": "f",
            "ï½†": "f",
            "á¸Ÿ": "f",
            "Æ’": "f",
            "ê¼": "f",
            "â“–": "g",
            "ï½‡": "g",
            "Çµ": "g",
            "Ä": "g",
            "á¸¡": "g",
            "ÄŸ": "g",
            "Ä¡": "g",
            "Ç§": "g",
            "Ä£": "g",
            "Ç¥": "g",
            "É ": "g",
            "êž¡": "g",
            "áµ¹": "g",
            "ê¿": "g",
            "â“—": "h",
            "ï½ˆ": "h",
            "Ä¥": "h",
            "á¸£": "h",
            "á¸§": "h",
            "ÈŸ": "h",
            "á¸¥": "h",
            "á¸©": "h",
            "á¸«": "h",
            "áº–": "h",
            "Ä§": "h",
            "â±¨": "h",
            "â±¶": "h",
            "É¥": "h",
            "Æ•": "hv",
            "â“˜": "i",
            "ï½‰": "i",
            "Ã¬": "i",
            "Ã­": "i",
            "Ã®": "i",
            "Ä©": "i",
            "Ä«": "i",
            "Ä­": "i",
            "Ã¯": "i",
            "á¸¯": "i",
            "á»‰": "i",
            "Ç": "i",
            "È‰": "i",
            "È‹": "i",
            "á»‹": "i",
            "Ä¯": "i",
            "á¸­": "i",
            "É¨": "i",
            "Ä±": "i",
            "â“™": "j",
            "ï½Š": "j",
            "Äµ": "j",
            "Ç°": "j",
            "É‰": "j",
            "â“š": "k",
            "ï½‹": "k",
            "á¸±": "k",
            "Ç©": "k",
            "á¸³": "k",
            "Ä·": "k",
            "á¸µ": "k",
            "Æ™": "k",
            "â±ª": "k",
            "ê": "k",
            "êƒ": "k",
            "ê…": "k",
            "êž£": "k",
            "â“›": "l",
            "ï½Œ": "l",
            "Å€": "l",
            "Äº": "l",
            "Ä¾": "l",
            "á¸·": "l",
            "á¸¹": "l",
            "Ä¼": "l",
            "á¸½": "l",
            "á¸»": "l",
            "Å¿": "l",
            "Å‚": "l",
            "Æš": "l",
            "É«": "l",
            "â±¡": "l",
            "ê‰": "l",
            "êž": "l",
            "ê‡": "l",
            "Ç‰": "lj",
            "â“œ": "m",
            "ï½": "m",
            "á¸¿": "m",
            "á¹": "m",
            "á¹ƒ": "m",
            "É±": "m",
            "É¯": "m",
            "â“": "n",
            "ï½Ž": "n",
            "Ç¹": "n",
            "Å„": "n",
            "Ã±": "n",
            "á¹…": "n",
            "Åˆ": "n",
            "á¹‡": "n",
            "Å†": "n",
            "á¹‹": "n",
            "á¹‰": "n",
            "Æž": "n",
            "É²": "n",
            "Å‰": "n",
            "êž‘": "n",
            "êž¥": "n",
            "ÇŒ": "nj",
            "â“ž": "o",
            "ï½": "o",
            "Ã²": "o",
            "Ã³": "o",
            "Ã´": "o",
            "á»“": "o",
            "á»‘": "o",
            "á»—": "o",
            "á»•": "o",
            "Ãµ": "o",
            "á¹": "o",
            "È­": "o",
            "á¹": "o",
            "Å": "o",
            "á¹‘": "o",
            "á¹“": "o",
            "Å": "o",
            "È¯": "o",
            "È±": "o",
            "Ã¶": "o",
            "È«": "o",
            "á»": "o",
            "Å‘": "o",
            "Ç’": "o",
            "È": "o",
            "È": "o",
            "Æ¡": "o",
            "á»": "o",
            "á»›": "o",
            "á»¡": "o",
            "á»Ÿ": "o",
            "á»£": "o",
            "á»": "o",
            "á»™": "o",
            "Ç«": "o",
            "Ç­": "o",
            "Ã¸": "o",
            "Ç¿": "o",
            "É”": "o",
            "ê‹": "o",
            "ê": "o",
            "Éµ": "o",
            "Æ£": "oi",
            "È£": "ou",
            "ê": "oo",
            "â“Ÿ": "p",
            "ï½": "p",
            "á¹•": "p",
            "á¹—": "p",
            "Æ¥": "p",
            "áµ½": "p",
            "ê‘": "p",
            "ê“": "p",
            "ê•": "p",
            "â“ ": "q",
            "ï½‘": "q",
            "É‹": "q",
            "ê—": "q",
            "ê™": "q",
            "â“¡": "r",
            "ï½’": "r",
            "Å•": "r",
            "á¹™": "r",
            "Å™": "r",
            "È‘": "r",
            "È“": "r",
            "á¹›": "r",
            "á¹": "r",
            "Å—": "r",
            "á¹Ÿ": "r",
            "É": "r",
            "É½": "r",
            "ê›": "r",
            "êž§": "r",
            "êžƒ": "r",
            "â“¢": "s",
            "ï½“": "s",
            "ÃŸ": "s",
            "Å›": "s",
            "á¹¥": "s",
            "Å": "s",
            "á¹¡": "s",
            "Å¡": "s",
            "á¹§": "s",
            "á¹£": "s",
            "á¹©": "s",
            "È™": "s",
            "ÅŸ": "s",
            "È¿": "s",
            "êž©": "s",
            "êž…": "s",
            "áº›": "s",
            "â“£": "t",
            "ï½”": "t",
            "á¹«": "t",
            "áº—": "t",
            "Å¥": "t",
            "á¹­": "t",
            "È›": "t",
            "Å£": "t",
            "á¹±": "t",
            "á¹¯": "t",
            "Å§": "t",
            "Æ­": "t",
            "Êˆ": "t",
            "â±¦": "t",
            "êž‡": "t",
            "êœ©": "tz",
            "â“¤": "u",
            "ï½•": "u",
            "Ã¹": "u",
            "Ãº": "u",
            "Ã»": "u",
            "Å©": "u",
            "á¹¹": "u",
            "Å«": "u",
            "á¹»": "u",
            "Å­": "u",
            "Ã¼": "u",
            "Çœ": "u",
            "Ç˜": "u",
            "Ç–": "u",
            "Çš": "u",
            "á»§": "u",
            "Å¯": "u",
            "Å±": "u",
            "Ç”": "u",
            "È•": "u",
            "È—": "u",
            "Æ°": "u",
            "á»«": "u",
            "á»©": "u",
            "á»¯": "u",
            "á»­": "u",
            "á»±": "u",
            "á»¥": "u",
            "á¹³": "u",
            "Å³": "u",
            "á¹·": "u",
            "á¹µ": "u",
            "Ê‰": "u",
            "â“¥": "v",
            "ï½–": "v",
            "á¹½": "v",
            "á¹¿": "v",
            "Ê‹": "v",
            "êŸ": "v",
            "ÊŒ": "v",
            "ê¡": "vy",
            "â“¦": "w",
            "ï½—": "w",
            "áº": "w",
            "áºƒ": "w",
            "Åµ": "w",
            "áº‡": "w",
            "áº…": "w",
            "áº˜": "w",
            "áº‰": "w",
            "â±³": "w",
            "â“§": "x",
            "ï½˜": "x",
            "áº‹": "x",
            "áº": "x",
            "â“¨": "y",
            "ï½™": "y",
            "á»³": "y",
            "Ã½": "y",
            "Å·": "y",
            "á»¹": "y",
            "È³": "y",
            "áº": "y",
            "Ã¿": "y",
            "á»·": "y",
            "áº™": "y",
            "á»µ": "y",
            "Æ´": "y",
            "É": "y",
            "á»¿": "y",
            "â“©": "z",
            "ï½š": "z",
            "Åº": "z",
            "áº‘": "z",
            "Å¼": "z",
            "Å¾": "z",
            "áº“": "z",
            "áº•": "z",
            "Æ¶": "z",
            "È¥": "z",
            "É€": "z",
            "â±¬": "z",
            "ê£": "z",
            "Î†": "Î‘",
            "Îˆ": "Î•",
            "Î‰": "Î—",
            "ÎŠ": "Î™",
            "Îª": "Î™",
            "ÎŒ": "ÎŸ",
            "ÎŽ": "Î¥",
            "Î«": "Î¥",
            "Î": "Î©",
            "Î¬": "Î±",
            "Î­": "Îµ",
            "Î®": "Î·",
            "Î¯": "Î¹",
            "ÏŠ": "Î¹",
            "Î": "Î¹",
            "ÏŒ": "Î¿",
            "Ï": "Ï…",
            "Ï‹": "Ï…",
            "Î°": "Ï…",
            "Ï‰": "Ï‰",
            "Ï‚": "Ïƒ"
        };
        return a
    }), a("select2/data/base", ["../utils"], function(a) {
        function b() {
            b.__super__.constructor.call(this)
        }
        return a.Extend(b, a.Observable), b.prototype.current = function() {
            throw new Error("The `current` method must be defined in child classes.")
        }, b.prototype.query = function() {
            throw new Error("The `query` method must be defined in child classes.")
        }, b.prototype.bind = function() {}, b.prototype.destroy = function() {}, b.prototype.generateResultId = function(b, c) {
            var d = b.id + "-result-";
            return d += a.generateChars(4), d += null != c.id ? "-" + c.id.toString() : "-" + a.generateChars(4)
        }, b
    }), a("select2/data/select", ["./base", "../utils", "jquery"], function(a, b, c) {
        function d(a, b) {
            this.$element = a, this.options = b, d.__super__.constructor.call(this)
        }
        return b.Extend(d, a), d.prototype.current = function(a) {
            var b = [],
                d = this;
            this.$element.find(":selected").each(function() {
                var a = c(this),
                    e = d.item(a);
                b.push(e)
            }), a(b)
        }, d.prototype.select = function(a) {
            var b = this;
            if (c(a.element).is("option")) return a.element.selected = !0, void this.$element.trigger("change");
            if (this.$element.prop("multiple")) this.current(function(c) {
                var d = [];
                a = [a], a.push.apply(a, c);
                for (var e = 0; e < a.length; e++) id = a[e].id, -1 === d.indexOf(id) && d.push(id);
                b.$element.val(d), b.$element.trigger("change")
            });
            else {
                var d = a.id;
                this.$element.val(d), this.$element.trigger("change")
            }
        }, d.prototype.unselect = function(a) {
            var b = this;
            if (this.$element.prop("multiple")) return c(a.element).is("option") ? (a.element.selected = !1, void this.$element.trigger("change")) : void this.current(function(c) {
                for (var d = [], e = 0; e < c.length; e++) id = c[e].id, id !== a.id && -1 === d.indexOf(id) && d.push(id);
                b.$element.val(d), b.$element.trigger("change")
            })
        }, d.prototype.bind = function(a) {
            var b = this;
            this.container = a, a.on("select", function(a) {
                b.select(a.data)
            }), a.on("unselect", function(a) {
                b.unselect(a.data)
            })
        }, d.prototype.destroy = function() {
            this.$element.find("*").each(function() {
                c.removeData(this, "data")
            })
        }, d.prototype.query = function(a, b) {
            var d = [],
                e = this,
                f = this.$element.children();
            f.each(function() {
                var b = c(this);
                if (b.is("option") || b.is("optgroup")) {
                    var f = e.item(b),
                        g = e.matches(a, f);
                    null !== g && d.push(g)
                }
            }), b({
                results: d
            })
        }, d.prototype.option = function(a) {
            var b;
            a.children ? (b = document.createElement("optgroup"), b.label = a.text) : (b = document.createElement("option"), b.innerText = a.text), a.id && (b.value = a.id), a.disabled && (b.disabled = !0), a.selected && (b.selected = !0);
            var d = c(b),
                e = this._normalizeItem(a);
            return e.element = b, c.data(b, "data", e), d
        }, d.prototype.item = function(a) {
            var b = {};
            if (b = c.data(a[0], "data"), null != b) return b;
            if (a.is("option")) b = {
                id: a.val(),
                text: a.html(),
                disabled: a.prop("disabled"),
                selected: a.prop("selected")
            };
            else if (a.is("optgroup")) {
                b = {
                    text: a.prop("label"),
                    children: []
                };
                for (var d = a.children("option"), e = [], f = 0; f < d.length; f++) {
                    var g = c(d[f]),
                        h = this.item(g);
                    e.push(h)
                }
                b.children = e
            }
            return b = this._normalizeItem(b), b.element = a[0], c.data(a[0], "data", b), b
        }, d.prototype._normalizeItem = function(a) {
            c.isPlainObject(a) || (a = {
                id: a,
                text: a
            }), a = c.extend({}, {
                text: ""
            }, a);
            var b = {
                selected: !1,
                disabled: !1
            };
            return null != a.id && (a.id = a.id.toString()), null != a.text && (a.text = a.text.toString()), null == a._resultId && a.id && null != this.container && (a._resultId = this.generateResultId(this.container, a)), c.extend({}, b, a)
        }, d.prototype.matches = function(a, b) {
            var c = this.options.get("matcher");
            return c(a, b)
        }, d
    }), a("select2/data/array", ["./select", "../utils", "jquery"], function(a, b, c) {
        function d(a, b) {
            var c = b.get("data") || [];
            d.__super__.constructor.call(this, a, b), a.append(this.convertToOptions(c))
        }
        return b.Extend(d, a), d.prototype.select = function(a) {
            var b = this.$element.find('option[value="' + a.id + '"]');
            0 === b.length && (b = this.option(a), this.$element.append(b)), d.__super__.select.call(this, a)
        }, d.prototype.convertToOptions = function(a) {
            function b(a) {
                return function() {
                    return c(this).val() == a.id
                }
            }
            for (var d = this, e = this.$element.find("option"), f = e.map(function() {
                    return d.item(c(this)).id
                }).get(), g = [], h = 0; h < a.length; h++) {
                var i = this._normalizeItem(a[h]);
                if (f.indexOf(i.id) >= 0) {
                    var j = e.filter(b(i)),
                        k = this.item(j),
                        l = (c.extend(!0, {}, k, i), this.option(k));
                    j.replaceWith(l)
                } else {
                    var m = this.option(i);
                    if (i.children) {
                        var n = this.convertToOptions(i.children);
                        m.append(n)
                    }
                    g.push(m)
                }
            }
            return g
        }, d
    }), a("select2/data/ajax", ["./array", "../utils", "jquery"], function(a, b, c) {
        function d(b, c) {
            this.ajaxOptions = c.get("ajax"), null != this.ajaxOptions.processResults && (this.processResults = this.ajaxOptions.processResults), a.__super__.constructor.call(this, b, c)
        }
        return b.Extend(d, a), d.prototype.processResults = function(a) {
            return a
        }, d.prototype.query = function(a, b) {
            function d() {
                var d = c.ajax(f);
                d.success(function(d) {
                    var f = e.processResults(d, a);
                    console && console.error && (f && f.results && c.isArray(f.results) || console.error("Select2: The AJAX results did not return an array in the `results` key of the response.")), b(f)
                }), e._request = d
            }
            var e = this;
            this._request && (this._request.abort(), this._request = null);
            var f = c.extend({
                type: "GET"
            }, this.ajaxOptions);
            "function" == typeof f.url && (f.url = f.url(a)), "function" == typeof f.data && (f.data = f.data(a)), this.ajaxOptions.delay && "" !== a.term ? (this._queryTimeout && window.clearTimeout(this._queryTimeout), this._queryTimeout = window.setTimeout(d, this.ajaxOptions.delay)) : d()
        }, d
    }), a("select2/data/tags", ["jquery"], function(a) {
        function b(b, c, d) {
            var e = d.get("tags"),
                f = d.get("createTag");
            if (void 0 !== f && (this.createTag = f), b.call(this, c, d), a.isArray(e))
                for (var g = 0; g < e.length; g++) {
                    var h = e[g],
                        i = this._normalizeItem(h),
                        j = this.option(i);
                    this.$element.append(j)
                }
        }
        return b.prototype.query = function(a, b, c) {
            function d(a, f) {
                for (var g = a.results, h = 0; h < g.length; h++) {
                    var i = g[h],
                        j = null != i.children && !d({
                            results: i.children
                        }, !0),
                        k = i.text === b.term;
                    if (k || j) return f ? !1 : (a.data = g, void c(a))
                }
                if (f) return !0;
                var l = e.createTag(b);
                if (null != l) {
                    var m = e.option(l);
                    m.attr("data-select2-tag", !0), e.$element.append(m), e.insertTag(g, l)
                }
                a.results = g, c(a)
            }
            var e = this;
            return this._removeOldTags(), null == b.term || "" === b.term || null != b.page ? void a.call(this, b, c) : void a.call(this, b, d)
        }, b.prototype.createTag = function(a, b) {
            return {
                id: b.term,
                text: b.term
            }
        }, b.prototype.insertTag = function(a, b, c) {
            b.unshift(c)
        }, b.prototype._removeOldTags = function() {
            var b = (this._lastTag, this.$element.find("option[data-select2-tag]"));
            b.each(function() {
                this.selected || a(this).remove()
            })
        }, b
    }), a("select2/data/tokenizer", ["jquery"], function(a) {
        function b(a, b, c) {
            var d = c.get("tokenizer");
            void 0 !== d && (this.tokenizer = d), a.call(this, b, c)
        }
        return b.prototype.bind = function(a, b, c) {
            a.call(this, b, c), this.$search = b.dropdown.$search || b.selection.$search || c.find(".select2-search__field")
        }, b.prototype.query = function(a, b, c) {
            function d(a) {
                e.select(a)
            }
            var e = this;
            b.term = b.term || "";
            var f = this.tokenizer(b, this.options, d);
            f.term !== b.term && (this.$search.length && (this.$search.val(f.term), this.$search.focus()), b.term = f.term), a.call(this, b, c)
        }, b.prototype.tokenizer = function(b, c, d, e) {
            for (var f = d.get("tokenSeparators") || [], g = c.term, h = 0, i = this.createTag || function(a) {
                    return {
                        id: a.term,
                        text: a.term
                    }
                }; h < g.length;) {
                var j = g[h];
                if (-1 !== f.indexOf(j)) {
                    var k = g.substr(0, h),
                        l = a.extend({}, c, {
                            term: k
                        }),
                        m = i(l);
                    e(m), g = g.substr(h + 1) || "", h = 0
                } else h++
            }
            return {
                term: g
            }
        }, b
    }), a("select2/data/minimumInputLength", [], function() {
        function a(a, b, c) {
            this.minimumInputLength = c.get("minimumInputLength"), a.call(this, b, c)
        }
        return a.prototype.query = function(a, b, c) {
            return b.term = b.term || "", b.term.length < this.minimumInputLength ? void this.trigger("results:message", {
                message: "inputTooShort",
                args: {
                    minimum: this.minimumInputLength,
                    input: b.term,
                    params: b
                }
            }) : void a.call(this, b, c)
        }, a
    }), a("select2/data/maximumInputLength", [], function() {
        function a(a, b, c) {
            this.maximumInputLength = c.get("maximumInputLength"), a.call(this, b, c)
        }
        return a.prototype.query = function(a, b, c) {
            return b.term = b.term || "", this.maximumInputLength > 0 && b.term.length > this.maximumInputLength ? void this.trigger("results:message", {
                message: "inputTooLong",
                args: {
                    minimum: this.maximumInputLength,
                    input: b.term,
                    params: b
                }
            }) : void a.call(this, b, c)
        }, a
    }), a("select2/data/maximumSelectionLength", [], function() {
        function a(a, b, c) {
            this.maximumSelectionLength = c.get("maximumSelectionLength"), a.call(this, b, c)
        }
        return a.prototype.query = function(a, b, c) {
            var d = this;
            this.current(function(e) {
                var f = null != e ? e.length : 0;
                return d.maximumSelectionLength > 0 && f >= d.maximumSelectionLength ? void d.trigger("results:message", {
                    message: "maximumSelected",
                    args: {
                        maximum: d.maximumSelectionLength
                    }
                }) : void a.call(d, b, c)
            })
        }, a
    }), a("select2/dropdown", ["jquery", "./utils"], function(a, b) {
        function c(a, b) {
            this.$element = a, this.options = b, c.__super__.constructor.call(this)
        }
        return b.Extend(c, b.Observable), c.prototype.render = function() {
            var b = a('<span class="select2-dropdown"><span class="select2-results"></span></span>');
            return b.attr("dir", this.options.get("dir")), this.$dropdown = b, b
        }, c.prototype.position = function() {}, c.prototype.destroy = function() {
            this.$dropdown.remove()
        }, c.prototype.bind = function(a) {
            var b = this;
            a.on("select", function(a) {
                b._onSelect(a)
            }), a.on("unselect", function(a) {
                b._onUnSelect(a)
            })
        }, c.prototype._onSelect = function() {
            this.trigger("close")
        }, c.prototype._onUnSelect = function() {
            this.trigger("close")
        }, c
    }), a("select2/dropdown/search", ["jquery", "../utils"], function(a) {
        function b() {}
        return b.prototype.render = function(b) {
            var c = b.call(this),
                d = a('<span class="select2-search select2-search--dropdown"><input class="select2-search__field" type="search" tabindex="-1" role="textbox" /></span>');
            return this.$searchContainer = d, this.$search = d.find("input"), c.prepend(d), c
        }, b.prototype.bind = function(a, b, c) {
            var d = this;
            a.call(this, b, c), this.$search.on("keydown", function(a) {
                d.trigger("keypress", a), d._keyUpPrevented = a.isDefaultPrevented()
            }), this.$search.on("keyup", function(a) {
                d.handleSearch(a)
            }), b.on("open", function() {
                d.$search.attr("tabindex", 0), d.$search.focus(), window.setTimeout(function() {
                    d.$search.focus()
                }, 0)
            }), b.on("close", function() {
                d.$search.attr("tabindex", -1), d.$search.val("")
            }), b.on("results:all", function(a) {
                if (null == a.query.term || "" === a.query.term) {
                    var b = d.showSearch(a);
                    b ? d.$searchContainer.removeClass("select2-search--hide") : d.$searchContainer.addClass("select2-search--hide")
                }
            })
        }, b.prototype.handleSearch = function() {
            if (!this._keyUpPrevented) {
                var a = this.$search.val();
                this.trigger("query", {
                    term: a
                })
            }
            this._keyUpPrevented = !1
        }, b.prototype.showSearch = function() {
            return !0
        }, b
    }), a("select2/dropdown/hidePlaceholder", [], function() {
        function a(a, b, c, d) {
            this.placeholder = this.normalizePlaceholder(c.get("placeholder")), a.call(this, b, c, d)
        }
        return a.prototype.append = function(a, b) {
            b.results = this.removePlaceholder(b.results), a.call(this, b)
        }, a.prototype.normalizePlaceholder = function(a, b) {
            return "string" == typeof b && (b = {
                id: "",
                text: b
            }), b
        }, a.prototype.removePlaceholder = function(a, b) {
            for (var c = b.slice(0), d = b.length - 1; d >= 0; d--) {
                var e = b[d];
                this.placeholder.id === e.id && c.splice(d, 1)
            }
            return c
        }, a
    }), a("select2/dropdown/infiniteScroll", ["jquery"], function(a) {
        function b(a, b, c, d) {
            this.lastParams = {}, a.call(this, b, c, d), this.$loadingMore = this.createLoadingMore(), this.loading = !1
        }
        return b.prototype.append = function(a, b) {
            this.$loadingMore.remove(), this.loading = !1, a.call(this, b), this.showLoadingMore(b) && this.$results.append(this.$loadingMore)
        }, b.prototype.bind = function(b, c, d) {
            var e = this;
            b.call(this, c, d), c.on("query", function(a) {
                e.lastParams = a, e.loading = !0
            }), c.on("query:append", function(a) {
                e.lastParams = a, e.loading = !0
            }), this.$results.on("scroll", function() {
                var b = a.contains(document.documentElement, e.$loadingMore[0]);
                if (!e.loading && b) {
                    var c = e.$results.offset().top + e.$results.outerHeight(!1),
                        d = e.$loadingMore.offset().top + e.$loadingMore.outerHeight(!1);
                    c + 50 >= d && e.loadMore()
                }
            })
        }, b.prototype.loadMore = function() {
            this.loading = !0;
            var b = a.extend({}, {
                page: 1
            }, this.lastParams);
            b.page++, this.trigger("query:append", b)
        }, b.prototype.showLoadingMore = function(a, b) {
            return b.pagination && b.pagination.more
        }, b.prototype.createLoadingMore = function() {
            var b = a('<li class="option load-more" role="treeitem"></li>'),
                c = this.options.get("translations").get("loadingMore");
            return b.html(c(this.lastParams)), b
        }, b
    }), a("select2/dropdown/attachBody", ["jquery", "../utils"], function(a, b) {
        function c(a, b, c) {
            this.$dropdownParent = c.get("dropdownParent") || document.body, a.call(this, b, c)
        }
        return c.prototype.bind = function(a, b, c) {
            var d = this,
                e = !1;
            a.call(this, b, c), b.on("open", function() {
                d._showDropdown(), d._attachPositioningHandler(b), e || (e = !0, b.on("results:all", function() {
                    d._positionDropdown(), d._resizeDropdown()
                }), b.on("results:append", function() {
                    d._positionDropdown(), d._resizeDropdown()
                }))
            }), b.on("close", function() {
                d._hideDropdown(), d._detachPositioningHandler(b)
            }), this.$dropdownContainer.on("mousedown", function(a) {
                a.stopPropagation()
            })
        }, c.prototype.position = function(a, b, c) {
            b.attr("class", c.attr("class")), b.removeClass("select2"), b.addClass("select2-container--open"), b.css({
                position: "absolute",
                top: -999999
            }), this.$container = c
        }, c.prototype.render = function(b) {
            var c = a("<span></span>"),
                d = b.call(this);
            return c.append(d), this.$dropdownContainer = c, c
        }, c.prototype._hideDropdown = function() {
            this.$dropdownContainer.detach()
        }, c.prototype._attachPositioningHandler = function(c) {
            var d = this,
                e = "scroll.select2." + c.id,
                f = "resize.select2." + c.id,
                g = "orientationchange.select2." + c.id;
            $watchers = this.$container.parents().filter(b.hasScroll), $watchers.each(function() {
                a(this).data("select2-scroll-position", {
                    x: a(this).scrollLeft(),
                    y: a(this).scrollTop()
                })
            }), $watchers.on(e, function() {
                var b = a(this).data("select2-scroll-position");
                a(this).scrollTop(b.y)
            }), a(window).on(e + " " + f + " " + g, function() {
                d._positionDropdown(), d._resizeDropdown()
            })
        }, c.prototype._detachPositioningHandler = function(c) {
            var d = "scroll.select2." + c.id,
                e = "resize.select2." + c.id,
                f = "orientationchange.select2." + c.id;
            $watchers = this.$container.parents().filter(b.hasScroll), $watchers.off(d), a(window).off(d + " " + e + " " + f)
        }, c.prototype._positionDropdown = function() {
            var b = a(window),
                c = this.$dropdown.hasClass("select2-dropdown--above"),
                d = this.$dropdown.hasClass("select2-dropdown--below"),
                e = null,
                f = (this.$container.position(), this.$container.offset());
            f.bottom = f.top + this.$container.outerHeight(!1);
            var g = {
                height: this.$container.outerHeight(!1)
            };
            g.top = f.top, g.bottom = f.top + g.height;
            var h = {
                    height: this.$dropdown.outerHeight(!1)
                },
                i = {
                    top: b.scrollTop(),
                    bottom: b.scrollTop() + b.height()
                },
                j = i.top < f.top - h.height,
                k = i.bottom > f.bottom + h.height,
                l = {
                    left: f.left,
                    top: g.bottom
                };
            c || d || (e = "below"), k || !j || c ? !j && k && c && (e = "below") : e = "above", ("above" == e || c && "below" !== e) && (l.top = g.top - h.height), null != e && (this.$dropdown.removeClass("select2-dropdown--below select2-dropdown--above").addClass("select2-dropdown--" + e), this.$container.removeClass("select2-container--below select2-container--above").addClass("select2-container--" + e)), this.$dropdownContainer.css(l)
        }, c.prototype._resizeDropdown = function() {
            this.$dropdownContainer.width(), this.$dropdown.css({
                width: this.$container.outerWidth(!1) + "px"
            })
        }, c.prototype._showDropdown = function() {
            this.$dropdownContainer.appendTo(this.$dropdownParent), this._positionDropdown(), this._resizeDropdown()
        }, c
    }), a("select2/dropdown/minimumResultsForSearch", [], function() {
        function a(b) {
            count = 0;
            for (var c = 0; c < b.length; c++) {
                var d = b[c];
                d.children ? count += a(d.children) : count++
            }
            return count
        }

        function b(a, b, c, d) {
            this.minimumResultsForSearch = c.get("minimumResultsForSearch"), a.call(this, b, c, d)
        }
        return b.prototype.showSearch = function(b, c) {
            return a(c.data.results) < this.minimumResultsForSearch ? !1 : b.call(this, c)
        }, b
    }), a("select2/dropdown/selectOnClose", [], function() {
        function a() {}
        return a.prototype.bind = function(a, b, c) {
            var d = this;
            a.call(this, b, c), b.on("close", function() {
                d._handleSelectOnClose()
            })
        }, a.prototype._handleSelectOnClose = function() {
            var a = this.getHighlightedResults();
            a.length < 1 || a.trigger("mouseup")
        }, a
    }), a("select2/i18n/en", [], function() {
        return {
            errorLoading: function() {
                return "The results could not be loaded."
            },
            inputTooLong: function(a) {
                var b = a.input.length - a.maximum,
                    c = "Please delete " + b + " character";
                return 1 != b && (c += "s"), c
            },
            inputTooShort: function(a) {
                var b = a.minimum - a.input.length,
                    c = "Please enter " + b + " or more characters";
                return c
            },
            loadingMore: function() {
                return "Loading more resultsâ€¦"
            },
            maximumSelected: function(a) {
                var b = "You can only select " + a.maximum + " item";
                return 1 != a.maximum && (b += "s"), b
            },
            noResults: function() {
                return "No results found"
            },
            searching: function() {
                return "Searchingâ€¦"
            }
        }
    }), a("select2/defaults", ["jquery", "./results", "./selection/single", "./selection/multiple", "./selection/placeholder", "./selection/allowClear", "./selection/search", "./selection/eventRelay", "./utils", "./translation", "./diacritics", "./data/select", "./data/array", "./data/ajax", "./data/tags", "./data/tokenizer", "./data/minimumInputLength", "./data/maximumInputLength", "./data/maximumSelectionLength", "./dropdown", "./dropdown/search", "./dropdown/hidePlaceholder", "./dropdown/infiniteScroll", "./dropdown/attachBody", "./dropdown/minimumResultsForSearch", "./dropdown/selectOnClose", "./i18n/en"], function(a, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B) {
        function C() {
            this.reset()
        }
        C.prototype.apply = function(l) {
            if (l = a.extend({}, this.defaults, l), null == l.dataAdapter) {
                if (l.dataAdapter = null != l.ajax ? o : null != l.data ? n : m, l.minimumInputLength > 0 && (l.dataAdapter = j.Decorate(l.dataAdapter, r)), l.maximumInputLength > 0 && (l.dataAdapter = j.Decorate(l.dataAdapter, s)), l.maximumSelectionLength > 0 && (l.dataAdapter = j.Decorate(l.dataAdapter, t)), null != l.tags && (l.dataAdapter = j.Decorate(l.dataAdapter, p)), (null != l.tokenSeparators || null != l.tokenizer) && (l.dataAdapter = j.Decorate(l.dataAdapter, q)), null != l.query) {
                    var B = b(l.amdBase + "compat/query");
                    l.dataAdapter = j.Decorate(l.dataAdapter, B)
                }
                if (null != l.initSelection) {
                    var C = b(l.amdBase + "compat/initSelection");
                    l.dataAdapter = j.Decorate(l.dataAdapter, C)
                }
            }
            if (null == l.resultsAdapter && (l.resultsAdapter = c, null != l.ajax && (l.resultsAdapter = j.Decorate(l.resultsAdapter, x)), null != l.placeholder && (l.resultsAdapter = j.Decorate(l.resultsAdapter, w)), l.selectOnClose && (l.resultsAdapter = j.Decorate(l.resultsAdapter, A))), null == l.dropdownAdapter) {
                if (l.multiple) l.dropdownAdapter = u;
                else {
                    var D = j.Decorate(u, v);
                    l.dropdownAdapter = D
                }
                l.minimumResultsForSearch > 0 && (l.dropdownAdapter = j.Decorate(l.dropdownAdapter, z)), l.dropdownAdapter = j.Decorate(l.dropdownAdapter, y)
            }
            if (null == l.selectionAdapter && (l.selectionAdapter = l.multiple ? e : d, null != l.placeholder && (l.selectionAdapter = j.Decorate(l.selectionAdapter, f), l.allowClear && (l.selectionAdapter = j.Decorate(l.selectionAdapter, g))), l.multiple && (l.selectionAdapter = j.Decorate(l.selectionAdapter, h)), l.selectionAdapter = j.Decorate(l.selectionAdapter, i)), "string" == typeof l.language)
                if (l.language.indexOf("-") > 0) {
                    var E = l.language.split("-"),
                        F = E[0];
                    l.language = [l.language, F]
                } else l.language = [l.language];
            if (a.isArray(l.language)) {
                var G = new k;
                l.language.push("en");
                for (var H = l.language, I = 0; I < H.length; I++) {
                    var J = H[I],
                        K = {};
                    try {
                        K = k.loadPath(J)
                    } catch (L) {
                        try {
                            J = this.defaults.amdLanguageBase + J, K = k.loadPath(J)
                        } catch (M) {
                            console && console.warn && console.warn('Select2: The lanugage file for "' + J + '" could not be automatically loaded. A fallback will be used instead.');
                            continue
                        }
                    }
                    G.extend(K)
                }
                l.translations = G
            } else l.translations = new k(l.language);
            return l
        }, C.prototype.reset = function() {
            function b(a) {
                function b(a) {
                    return l[a] || a
                }
                return a.replace(/[^\u0000-\u007E]/g, b)
            }

            function c(d, e) {
                if ("" === a.trim(d.term)) return e;
                if (e.children && e.children.length > 0) {
                    for (var f = a.extend(!0, {}, e), g = e.children.length - 1; g >= 0; g--) {
                        var h = e.children[g],
                            i = c(d, h);
                        null == i && f.children.splice(g, 1)
                    }
                    return f.children.length > 0 ? f : c(d, f)
                }
                var j = b(e.text).toUpperCase(),
                    k = b(d.term).toUpperCase();
                return j.indexOf(k) > -1 ? e : null
            }
            this.defaults = {
                amdBase: "select2/",
                amdLanguageBase: "select2/i18n/",
                language: B,
                matcher: c,
                minimumInputLength: 0,
                maximumInputLength: 0,
                maximumSelectionLength: 0,
                minimumResultsForSearch: 0,
                selectOnClose: !1,
                sorter: function(a) {
                    return a
                },
                templateResult: function(a) {
                    return a.text
                },
                templateSelection: function(a) {
                    return a.text
                },
                theme: "default",
                width: "resolve"
            }
        }, C.prototype.set = function(b, c) {
            var d = a.camelCase(b),
                e = {};
            e[d] = c;
            var f = j._convertData(e);
            a.extend(this.defaults, f)
        };
        var D = new C;
        return D
    }), a("select2/options", ["jquery", "./defaults", "./utils"], function(a, b, c) {
        function d(a, c) {
            this.options = a, null != c && this.fromElement(c), this.options = b.apply(this.options)
        }
        return d.prototype.fromElement = function(b) {
            var d = ["select2"];
            null == this.options.multiple && (this.options.multiple = b.prop("multiple")), null == this.options.disabled && (this.options.disabled = b.prop("disabled")), null == this.options.language && (b.prop("lang") ? this.options.language = b.prop("lang").toLowerCase() : b.closest("[lang]").prop("lang") && (this.options.language = b.closest("[lang]").prop("lang"))), null == this.options.dir && (this.options.dir = b.prop("dir") ? b.prop("dir") : b.closest("[dir]").prop("dir") ? b.closest("[dir]").prop("dir") : "ltr"), b.prop("disabled", this.options.disabled), b.prop("multiple", this.options.multiple), b.data("select2-tags") && (console && console.warn && console.warn('Select2: The `data-select2-tags` attribute has been changed to use the `data-data` and `data-tags="true"` attributes and will be removed in future versions of Select2.'), b.data("data", b.data("select2-tags")), b.data("tags", !0)), b.data("ajax-url") && (console && console.warn && console.warn("Select2: The `data-ajax-url` attribute has been changed to `data-ajax--url` and support for the old attribute will be removed in future versions of Select2."), b.data("ajax--url", b.data("ajax-url")));
            var e = b.data();
            e = c._convertData(e);
            for (var f in e) d.indexOf(f) > -1 || (a.isPlainObject(this.options[f]) ? a.extend(this.options[f], e[f]) : this.options[f] = e[f]);
            return this
        }, d.prototype.get = function(a) {
            return this.options[a]
        }, d.prototype.set = function(a, b) {
            this.options[a] = b
        }, d
    }), a("select2/core", ["jquery", "./options", "./utils", "./keys"], function(a, b, c, d) {
        var e = function(a, c) {
            null != a.data("select2") && a.data("select2").destroy(), this.$element = a, this.id = this._generateId(a), c = c || {}, this.options = new b(c, a), e.__super__.constructor.call(this);
            var d = this.options.get("dataAdapter");
            this.data = new d(a, this.options);
            var f = this.render();
            this._placeContainer(f);
            var g = this.options.get("selectionAdapter");
            this.selection = new g(a, this.options), this.$selection = this.selection.render(), this.selection.position(this.$selection, f);
            var h = this.options.get("dropdownAdapter");
            this.dropdown = new h(a, this.options), this.$dropdown = this.dropdown.render(), this.dropdown.position(this.$dropdown, f);
            var i = this.options.get("resultsAdapter");
            this.results = new i(a, this.options, this.data), this.$results = this.results.render(), this.results.position(this.$results, this.$dropdown);
            var j = this;
            this._bindAdapters(), this._registerDomEvents(), this._registerDataEvents(), this._registerSelectionEvents(), this._registerDropdownEvents(), this._registerResultsEvents(), this._registerEvents(), this.data.current(function(a) {
                j.trigger("selection:update", {
                    data: a
                })
            }), a.hide(), this._syncAttributes(), this._tabindex = a.attr("tabindex") || 0, a.attr("tabindex", "-1"), a.data("select2", this)
        };
        return c.Extend(e, c.Observable), e.prototype._generateId = function(a) {
            var b = "";
            return b = null != a.attr("id") ? a.attr("id") : null != a.attr("name") ? a.attr("name") + "-" + c.generateChars(2) : c.generateChars(4), b = "select2-" + b
        }, e.prototype._placeContainer = function(a) {
            a.insertAfter(this.$element);
            var b = this._resolveWidth(this.$element, this.options.get("width"));
            null != b && a.css("width", b)
        }, e.prototype._resolveWidth = function(a, b) {
            var c = /^width:(([-+]?([0-9]*\.)?[0-9]+)(px|em|ex|%|in|cm|mm|pt|pc))/i;
            if ("resolve" == b) {
                var d = this._resolveWidth(a, "style");
                return null != d ? d : this._resolveWidth(a, "element")
            }
            if ("element" == b) {
                var e = a.outerWidth(!1);
                return 0 >= e ? "auto" : e + "px"
            }
            if ("style" == b) {
                var f = a.attr("style");
                if ("string" != typeof f) return null;
                var g = f.split(";");
                for (i = 0, l = g.length; l > i; i += 1) {
                    attr = g[i].replace(/\s/g, "");
                    var h = attr.match(c);
                    if (null !== h && h.length >= 1) return h[1]
                }
                return null
            }
            return b
        }, e.prototype._bindAdapters = function() {
            this.data.bind(this, this.$container), this.selection.bind(this, this.$container), this.dropdown.bind(this, this.$container), this.results.bind(this, this.$container)
        }, e.prototype._registerDomEvents = function() {
            var b = this;
            this.$element.on("change.select2", function() {
                b.data.current(function(a) {
                    b.trigger("selection:update", {
                        data: a
                    })
                })
            }), this._sync = c.bind(this._syncAttributes, this), this.$element[0].attachEvent && this.$element[0].attachEvent("onpropertychange", this._sync);
            var d = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
            null != d && (this._observer = new d(function(c) {
                a.each(c, b._sync)
            }), this._observer.observe(this.$element[0], {
                attributes: !0,
                subtree: !1
            }))
        }, e.prototype._registerDataEvents = function() {
            var a = this;
            this.data.on("*", function(b, c) {
                a.trigger(b, c)
            })
        }, e.prototype._registerSelectionEvents = function() {
            var a = this,
                b = ["toggle"];
            this.selection.on("toggle", function() {
                a.toggleDropdown()
            }), this.selection.on("*", function(c, d) {
                -1 === b.indexOf(c) && a.trigger(c, d)
            })
        }, e.prototype._registerDropdownEvents = function() {
            var a = this;
            this.dropdown.on("*", function(b, c) {
                a.trigger(b, c)
            })
        }, e.prototype._registerResultsEvents = function() {
            var a = this;
            this.results.on("*", function(b, c) {
                a.trigger(b, c)
            })
        }, e.prototype._registerEvents = function() {
            var a = this;
            this.on("open", function() {
                a.$container.addClass("select2-container--open")
            }), this.on("close", function() {
                a.$container.removeClass("select2-container--open")
            }), this.on("enable", function() {
                a.$container.removeClass("select2-container--disabled")
            }), this.on("disable", function() {
                a.$container.addClass("select2-container--disabled")
            }), this.on("query", function(b) {
                this.data.query(b, function(c) {
                    a.trigger("results:all", {
                        data: c,
                        query: b
                    })
                })
            }), this.on("query:append", function(b) {
                this.data.query(b, function(c) {
                    a.trigger("results:append", {
                        data: c,
                        query: b
                    })
                })
            }), this.on("keypress", function(b) {
                var c = b.which;
                a.isOpen() ? c === d.ENTER ? (a.trigger("results:select"), b.preventDefault()) : c === d.UP ? (a.trigger("results:previous"), b.preventDefault()) : c === d.DOWN ? (a.trigger("results:next"), b.preventDefault()) : (c === d.ESC || c === d.TAB) && (a.close(), b.preventDefault()) : (c === d.ENTER || c === d.SPACE || (c === d.DOWN || c === d.UP) && b.altKey) && (a.open(), b.preventDefault())
            })
        }, e.prototype._syncAttributes = function() {
            this.options.set("disabled", this.$element.prop("disabled")), this.options.get("disabled") ? (this.isOpen() && this.close(), this.trigger("disable")) : this.trigger("enable")
        }, e.prototype.trigger = function(a, b) {
            var c = e.__super__.trigger,
                d = {
                    open: "opening",
                    close: "closing",
                    select: "selecting",
                    unselect: "unselecting"
                };
            if (a in d) {
                var f = d[a],
                    g = {
                        prevented: !1,
                        name: a,
                        args: b
                    };
                if (c.call(this, f, g), g.prevented) return void(b.prevented = !0)
            }
            c.call(this, a, b)
        }, e.prototype.toggleDropdown = function() {
            this.options.get("disabled") || (this.isOpen() ? this.close() : this.open())
        }, e.prototype.open = function() {
            this.isOpen() || (this.trigger("query", {}), this.trigger("open"))
        }, e.prototype.close = function() {
            this.isOpen() && this.trigger("close")
        }, e.prototype.isOpen = function() {
            return this.$container.hasClass("select2-container--open")
        }, e.prototype.enable = function(a) {
            console && console.warn && console.warn('Select2: The `select2("enable")` method has been deprecated and will be removed in later Select2 versions. Use $element.prop("disabled") instead.'), 0 === a.length && (a = [!0]);
            var b = !a[0];
            this.$element.prop("disabled", b)
        }, e.prototype.val = function(b) {
            if (console && console.warn && console.warn('Select2: The `select2("val")` method has been deprecated and will be removed in later Select2 versions. Use $element.val() instead.'), 0 === b.length) return this.$element.val();
            var c = b[0];
            a.isArray(c) && (c = a.map(c, function(a) {
                return a.toString()
            })), this.$element.val(c).trigger("change")
        }, e.prototype.destroy = function() {
            this.$container.remove(), this.$element[0].detachEvent && this.$element[0].detachEvent("onpropertychange", this._sync), null != this._observer && (this._observer.disconnect(), this._observer = null), this._sync = null, this.$element.off(".select2"), this.$element.attr("tabindex", this._tabindex), this.$element.show(), this.$element.removeData("select2"), this.data.destroy(), this.selection.destroy(), this.dropdown.destroy(), this.results.destroy(), this.data = null, this.selection = null, this.dropdown = null, this.results = null
        }, e.prototype.render = function() {
            var b = a('<span class="select2 select2-container"><span class="selection"></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>');
            return b.attr("dir", this.options.get("dir")), this.$container = b, this.$container.addClass("select2-container--" + this.options.get("theme")), b.data("element", this.$element), b
        }, e
    }), a("jquery.select2", ["jquery", "./select2/core", "./select2/defaults"], function(a, c, d) {
        try {
            b("jquery.mousewheel")
        } catch (e) {}
        return null == a.fn.select2 && (a.fn.select2 = function(b) {
            if (b = b || {}, "object" == typeof b) return this.each(function() {
                {
                    var d = a.extend({}, b, !0);
                    new c(a(this), d)
                }
            }), this;
            if ("string" == typeof b) {
                var d = this.data("select2"),
                    e = Array.prototype.slice.call(arguments, 1);
                return d[b](e)
            }
            throw new Error("Invalid arguments for Select2: " + b)
        }), null == a.fn.select2.defaults && (a.fn.select2.defaults = d), c
    }), b("jquery.select2"), jQuery.fn.select2.amd = {
        define: a,
        require: b
    }
}();
