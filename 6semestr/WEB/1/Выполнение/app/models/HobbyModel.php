<?php

class HobbyModel extends Model {
	public function get_data() {	
		return [
            [
                'id' => 'Hobbies',
                'idh' => 'hobbies',
                'texth' => 'Хобби',
                'desc' => [
                    [
                        'id' => 'Hobbie1',
                        'desc' => 'Hobbie 1'
                    ],
                    [
                        'id' => 'Hobbie2',
                        'desc' => 'Hobbie 2'
                    ],
                    [
                        'id' => 'Hobbie3',
                        'desc' => 'Hobbie 3'
                    ],
                    [
                        'id' => 'Hobbie4',
                        'desc' => 'Hobbie 4'
                    ],
                    [
                        'id' => 'Hobbie5',
                        'desc' => 'Hobbie 5'
                    ]
                ],
            ],
            [
                'id' => 'Books',
                'idh' => 'books',
                'texth' => 'Книги',
                'desc' => [
                    [
                        'id' => 'Book1',
                        'desc' => 'Book 1'
                    ],
                    [
                        'id' => 'Book2',
                        'desc' => 'Book 2'
                    ],
                    [
                        'id' => 'Book3',
                        'desc' => 'Book 3'
                    ],
                    [
                        'id' => 'Book4',
                        'desc' => 'Book 4'
                    ],
                    [
                        'id' => 'Book5',
                        'desc' => 'Book 5'
                    ]
                ],
            ]
        ];
	}
}